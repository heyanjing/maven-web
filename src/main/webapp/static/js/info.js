R.ns("Edu.User.Info", {
	uploadRoot : DIR_URL,
	updateImg : function(callback) {
		var me = this;
		var Default = Edu.User.Default;
		var _me = {};
		callback = callback || $.noop;
		// 相机初始化
		var imageURL = "";
		var idCard = $('#myidCard').val();
		var d_me = Edu.User.Default;
		var day = d_me.config.LOCK_DAY || 3;
		var c = new Camera({
			title : "人脸识别　　　　　　　　　　注意:使用照片注册或学习，学时记为无效且将停学" + day + "天",
			url : CTX + "/face/capture?params=" + idCard
		});
		me.success = false;
		c.onclose = me.onclose;
		c.onCaptureUploadComplete = function(data) {
			if (data.url) {
				imageURL = data.url;
				$.ajax({
					url : CTX + "/user/info/photo",
					data : {
						idCard : idCard,
						faceUrl : imageURL
					},
					timeout : 20000,
					success : function(result) {
						if (result.success && result.success == true) {
							R.Cookie.set('tb_user_face_' + idCard, result.url, {
								path : CTX
							});
							me.success = true;
							c.close();
							$('#user-photo').attr("src", me.uploadRoot + result.url);
							R.Msg.success("修改成功!");
						} else {
							var msg = result.msg || '修改失败！';
							if (result.FACE_ERROR_CODE && result.FACE_ERROR_CODE == 'FACE_ERROR_CODE') {
								if (!me.count) {
									me.count = 0;
								}
								me.count++;
								R.Msg.warn(msg);
								if (me.count >= 3) {
									R.Dialog.confirm("操作失败，是否申请人像审核?", function(btn) {
										if (btn == 'yes') {
											me.audit(imageURL, result);
										}
									});
								} else {
									Default.reCapture(c);
								}
							} else {
								R.Msg.warn(msg);
							}
						}
					},
					error : function() {
						Default.reCapture(c);
					}
				});
			} else {
				Default.reCapture(c);
			}
		}
		c.show();
	},
	audit : function(imageURL, result) {
		var Default = Edu.User.Default;
		var idCard = $('#myidCard').val();
		var type = 2;
		// 默认 修改注册照照片
		if ($('#user-photo[havepic]').length <= 0) {
			type = 1;
			// 注册照照片
		}
		R.Ajax.request({
			url : CTX + "/admin/face/check/apply",
			data : {
				faceLogId : result.faceLogId,
				type : type,
				idCard : idCard
				// orgCode : result.orgCode,
				// faceUrl : imageURL,
				// similarIdCard : result.similarIdCard,
				// similarFaceUrl : result.similarFaceUrl,
				// similar : result.similar
			},
			success : function(data) {
				if (data.success == true) {
					var zIndex = 1;
					try {
						zIndex = (Default.c.w.zIndex || 1) + 1;
					} catch (err) {
						zIndex = Default.getMaxZIndex() + 1;
					}
					R.Dialog.confirm("申请成功, 立即查看审核结果?", "提示", function(btn) {
						if (btn == 'yes') {
							window.location.href = CTX + "/user/audit";
						}
					}, {
						zIndex : zIndex
					});
				} else {
					R.Msg.info(data.msg || '申请人工审核失败!');
				}
			}
		});
	},
	style : {
		success : function(obj, msg) {
			obj.next().removeClass("n-error").addClass("n-ok");
			obj.next().children().children().first().addClass('n-icon n-icon-h');
			obj.next().children().children().last().html(msg || "");
		},
		error : function(obj, msg) {
			obj.next().removeClass("n-ok").addClass("n-error");
			obj.next().children().children().first().addClass('n-icon n-icon-h');
			obj.next().children().children().last().html(msg || "");
		}
	},

	_clock : {
		seconds : 60,
		start : function(t) {
			var imm = t || this.seconds;
			var showText = $('#showText');
			Edu.User.Info.interval = setInterval(function() {
				if (imm > 0) {
					imm--;
					showText.html("&nbsp;&nbsp;" + imm + "秒后重新获取验证码");
				} else {
					clearInterval(Edu.User.Info.interval);
					// 去除计时
					$('#getBtn').val('重新获取');
					$('#getBtn').show();
					showText.hide();
				}
			}, 1000);
		}
	},
	// 验证码正确/错误样式
	_style : {
		success : function(obj, msg) {
			obj.removeClass("n-error").addClass("n-ok").children().removeClass("n-error").addClass("n-ok").children().first().addClass('n-icon').next().html(msg || "");
		},
		error : function(obj, msg) {
			obj.removeClass("n-ok").addClass("n-error").children().removeClass("n-ok").addClass("n-error").children().first().addClass('n-icon').next().html(msg || "");
		}
	},

	// /////简单的信息和判断///////////
	_check : {
		test : function(val) {
			if (val == null || val == -1) {
				return false;
			} else {
				return true;
			}
		}
	},
	init : function() {
		var me = this;
		var _me = {};
		var $formShow = $('#form-show');
		var $formEdit = $('#form-edit');
		var $modify = $('#modify');
		var $complete = $('#complete');
		var $name = $('input[name=name]');
		var $mobile = $('input[name=mobile]');
		var $email = $('input[name=email]');
		var idCard = $('#myidCard').val();
		var $orgCode = $('input[name=orgCode]');
		var $projectId = $('input[name=projectId]');
		var $subjectId = $('input[name=subjectId]');

		// 资格证修改
		var update = $('.update');
		var save = $('.save');
		var basicInfo = $('.basic-info');
		var certification = $('.certification');
		var check = $('#basic');
		var checks = $('#certification');
		var authenticationInfo = $('.authenticationInfo');
		var authenticationUpdate = $('.authenticationUpdate');
		var authenticationNo = $('input[name=number]');
		var authenticationDate = $('input[name=date]');

		if (checks) {
			check.find('a').click(function() {
				basicInfo.show();
				certification.hide()
				checks.removeClass('tab-check');
				check.addClass('tab-check');
			});
			checks.find('a').click(function() {
				basicInfo.hide();
				certification.show();
				check.removeClass('tab-check');
				checks.addClass('tab-check');
			});
		}
		authenticationNo.each(function(i) {
			authenticationNo.eq(i).on('click', function() {
				if (R.isEmpty(authenticationNo.eq(i).val())) {
					authenticationNo.eq(i).val(idCard)
				}
			});
		});

		update.click(function() {
			authenticationInfo.hide();
			authenticationUpdate.show();
			update.hide();
			save.show();
		});
		save.click(function() {
			var aflag = true;
			var dflag = true;
			authenticationNo.each(function(i) {
				if (R.isEmpty(authenticationNo.eq(i).val())) {
					me.style.error(authenticationNo.eq(i), "资格证号不能为空!");
					aflag = false;
				} else {
					me.style.success(authenticationNo.eq(i));
				}
			});

			authenticationDate.each(function(i) {
				if (R.isEmpty(authenticationDate.eq(i).val())) {
					me.style.error(authenticationDate.eq(i), "获证时间不能为空!");
					dflag = false;
				} else {
					me.style.success(authenticationDate.eq(i));
				}
			});
			// save.eq(i).on('click',function() {
			// if
			// (R.isEmpty(authenticationNo.eq(i).val()))
			// {
			// me.style.error(authenticationNo.eq(i),"资格证号不能为空!");
			// aflag = false;
			// } else {
			// me.style.success(authenticationNo.eq(i));
			// aflag = true;
			// }
			// if
			// (R.isEmpty(authenticationDate.eq(i).val()))
			// {
			// me.style.error(authenticationDate.eq(i),"获证时间不能为空!");
			// dflag = false;
			// } else {
			// me.style.success(authenticationDate.eq(i));
			// dflag = true;
			// }
			if (aflag && dflag) {
				var flag = true;
				var one = $('form[name=one]');
				var two = $('form[name=two]');
				var three = $('form[name=three]');
				var four = $('form[name=four]');
				var five = $('form[name=five]');
				// authenticationUpdate.eq(i).submit();
				authenticationInfo.show();
				authenticationUpdate.hide();
				if (one.length > 0) {
					$.ajax({
						url : CTX + '/admin/user/authentication/save',
						type : 'POST',
						data : $('form[name=one]').serialize(),
						async : false,
						success : function(data) {
							if (data.success) {
								flag = true;
							} else {
								flag = false;
							}
						}
					});
				}
				if (two.length > 0) {
					$.ajax({
						url : CTX + '/admin/user/authentication/save',
						type : 'POST',
						data : $('form[name=two]').serialize(),
						async : false,
						success : function(data) {
							if (data.success) {
								flag = true;
							} else {
								flag = false;
							}
						}
					});
				}

				if (three.length > 0) {
					$.ajax({
						url : CTX + '/admin/user/authentication/save',
						type : 'POST',
						data : $('form[name=three]').serialize(),
						async : false,
						success : function(data) {
							if (data.success) {
								flag = true;
							} else {
								flag = false;
							}
						}
					});
				}
				if (four.length > 0) {
					$.ajax({
						url : CTX + '/admin/user/authentication/save',
						type : 'POST',
						data : $('form[name=four]').serialize(),
						async : false,
						success : function(data) {
							if (data.success) {
								flag = true;
							} else {
								flag = false;
							}
						}
					});
				}
				if (five.length > 0) {
					$.ajax({
						url : CTX + '/admin/user/authentication/save',
						type : 'POST',
						data : $('form[name=five]').serialize(),
						async : false,
						success : function(data) {
							if (data.success) {
								flag = true;
							} else {
								flag = false;
							}
						}
					});
				}
				if (flag == true) {
					R.Msg.info("保存成功");
					save.attr("disabled", "disabled")
					setTimeout(function() {
						location.href = location.href;
					}, 1000);
				} else {
					R.Msg.info("保存失败");
				}
			}
			// });
		});

		// 日期控件
		$("input[name=date]").each(function() {
			$(this).datepicker({
				format : "yyyy-mm-dd",
				language : "zh-CN",
				autoclose : true,
				todayBtn : "linked",
				endDate : new Date()
			});

		});

		// 修改前改变样式
		$modify.click(function() {
			$formShow.hide();
			$formEdit.show();
			$modify.hide();
			$complete.show();
			var tags = [];
			tags.push('<li>');
			tags.push('	<div>');
			tags.push('		<i>验&nbsp;&nbsp;证&nbsp;码:<span style="color:red;font-weight:bold">*</span></i>');
			tags.push('		<input class="verification" type="text" id="mobileCode" name="mobileCode" value="">');
			tags.push('		<button id="getBtn" type="button" style="width: 100px;height: 28px;border-radius: 5px;background: #08c;color: #fff;">获取短信验证码</button>');
			tags.push('		<span id="showText" class="last-time"></span>');
			tags.push('		<span class="msg-box n-ok"> <span class="msg-wrap n-error n-error-hint" style="margin-top: 10px;"> <span></span> <span class="n-msg"></span> </span> </span>');
			tags.push('	</div>');
			tags.push('</li>');
			tags = tags.join('');

			$mobile.blur(function() {
				var $this = $(this);
				$oldMobile = $('#oldMobile');
				$mobileCode = $('#mobileCode');
				var length = $mobileCode ? $mobileCode.length : 0;
				$.ajax({
					url : CTX + '/user/mobile/need/validate',
					type : 'post',
					data : {
						orgCode : $orgCode.val(),
						subjectId : $subjectId.val()
					},
					success : function(result) {
						if (result) {
							// 和之前的手机号码不同且验证码框不存在则显示
							if ($oldMobile.val() != $this.val() && length < 1) {
								// 追加
								$this.parent().after(tags);
								// 验证码字段校验
								$('#mobileCode').blur(function() {
									var $this = $(this);
									if (R.isNotEmpty($this.val())) {
										me._style.success($this.next().next().next());
									} else {
										me._style.error($this.next().next().next(), "请输入验证码");
									}
								});
								// 获取验证码
								$('#getBtn').click(function() {
									if (Constants.Mobile.regex.test($this.val())) {
										$.ajax({
											url : CTX + '/reg/get/mobile/code',
											type : 'post',
											data : {
												idCard : idCard,
												userName : $name.val(),
												mobile : $this.val(),
												type : 0
											},
											success : function(result) {
												if (result.success) {
													// 发送成功,可以输入验证码
													_me.data = result.data;
													var min = 0.1;
													if (result.data && result.data > 0) {
														min = result.data;
													}
													var sec = min * 60;
													var mobileCodeTips = [];
													mobileCodeTips.push('<li><i class="ui-tiptext-icon" title="成功">&nbsp;</i>验证码已发送到您的手机，<strong>' + min + '</strong>分钟内输入有效，请勿泄露</li>');
													mobileCodeTips.join('');
													if ($('.ui-tiptext-icon').length == 0) {
														$this.parent().next().after(mobileCodeTips);
													}
													$('.ui-tiptext-success strong').text(min);
													$('.ui-tiptext-success').show();
													$('.ui-tiptext-error').hide();
													$('#getBtn').hide();
													$('#showText').html("&nbsp;&nbsp;" + sec + "秒后重新获取验证码");
													$('#showText').show();
													me._clock.seconds = sec;
													me._clock.start();
												} else {
													var msg = result.msg || '操作失败';
													R.Msg.info(msg + '请稍后在试');
												}
											}
										});
									} else {
										R.Msg.info("请填写正确的手机号码后再获取验证码!");
									}
								});
							} else {
								// 删除
								if ($oldMobile.val() == $this.val() && length > 0) {
									$mobileCode.parent().parent().next().remove();
									$mobileCode.parent().parent().remove();
								}
							}
						}
					}
				});
			});
		});

		var nflag = mflag = eflag = aflag = dflag = cflag = false;
		nameValidate = function() {
			// \u4e00-\u9faf --> \u4E00-\u9FA5
			if (R.isNotEmpty($name.val()) && /^(([A-Za-z])|([\u4e00-\u9fa5]))+$/.test($name.val())) {
				me.style.success($name);
				nflag = true;
			} else {
				me.style.error($name, "请输入汉字或者英文");
				nflag = false;
			}
			return nflag;
		}

		$name.blur(function() {
			nameValidate();
		});
		mobileValidate = function() {
			if (Constants.Mobile.regex.test($mobile.val())) {
				$.ajax({
					url : CTX + "/reg/mobile",
					async : false,
					data : {
						mobile : $mobile.val(),
						idCard : idCard
					},
					success : function(data) {
						if (data.success == false) {
							me.style.error($mobile, data.msg || "请输入正确的手机号码");
							mflag = false;
						} else {
							me.style.success($mobile);
							mflag = true;
						}
					}
				});
			} else {
				me.style.error($mobile, "请输入正确的手机号码");
				mflag = false;
			}
			return mflag;
		}
		$mobile.blur(function() {
			mobileValidate();
		});
		emailValidate = function() {
			if (R.isNotEmpty($email.val())) {
				if (/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test($email.val())) {
					$.ajax({
						url : CTX + '/user/info/email',
						async : false,
						data : {
							email : $email.val()
						},
						success : function(data) {
							if (data.success == false) {
								me.style.error($email, data.msg || "邮箱格式不正确");
								eflag = false;
							} else {
								me.style.success($email);
								eflag = true;
							}
						}
					});
				} else {
					me.style.error($email, "邮箱格式不正确");
					eflag = false;
				}
			} else {
				me.style.success($email);
				eflag = true;
			}
			return eflag;
		}
		$email.blur(function() {
			emailValidate();
		});
		// 提交表单
		$complete.click(function() {
			// var nflag, mflag, eflag, aflag, dflag,
			// cflag;
			// if (projectId.val() == 3) {
			// if (R.isEmpty(authenticationNo.val())) {
			// me.style.error(authenticationNo,"资格证号不能为空!");
			// aflag = false;
			// } else {
			// me.style.success(authenticationNo);
			// aflag = true;
			// }
			// if (R.isEmpty(authenticationDate.val()))
			// {
			// me.style.error(authenticationDate,"获取时间不能为空!");
			// dflag = false;
			// } else {
			// me.style.success(authenticationDate);
			// dflag = true;
			// }
			// }
			// }
			nflag = nameValidate();
			mflag = mobileValidate();
			eflag = emailValidate();

			$mobileCode = $('#mobileCode');
			if ($mobileCode && $mobileCode.length > 0) {
				if (R.isNotEmpty($mobileCode.val())) {
					me._style.success($mobileCode.next().next().next());
					cflag = true;
				} else {
					me._style.error($mobileCode.next().next().next(), "请输入验证码");
					cflag = false;
				}
			} else {
				cflag = true;
			}
			if (nflag && mflag && eflag && cflag) {
				// if (projectId.val() == 3) {
				// if (aflag && dflag) {
				// $formEdit.submit();
				// }
				// } else {
				// $formEdit.submit();

				$.ajax({
					url : CTX + '/user/info/update',
					type : 'post',
					data : {
						subjectId : $subjectId.val(),
						idCard : idCard,
						name : $name.val(),
						mobile : $mobile.val(),
						mobileCode : $mobileCode.val(),
						email : $email.val()
					},
					success : function(result) {
						if (result.success) {
							R.Msg.info(result.msg || '操作成功');
							Edu.User.Info.interval = setInterval(function() {
								window.location.href = CTX + '/user/info';
							}, 500);
						} else {
							R.Msg.info(result.msg || '验证失败，请重新验证');
						}
					}
				});
			}
		});

		// 鼠标经过改变相框状态
		$("#info-photo").hover(function() {
			$("#info-photo-revise").show();
		}, function() {
			$("#info-photo-revise").hide();
		}).click(function() {
			me.updateImg();
		});
		// 日期控件
		$("#certificatetime").datepicker({
			format : "yyyy-mm-dd",
			language : "zh-CN",
			autoclose : true,
			todayBtn : "linked",
			endDate : new Date()
		});
	}
});
