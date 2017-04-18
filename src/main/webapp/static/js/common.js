window.R = {
    ns : function(className, data) {
        var cns = className.split('.'), o = window;
        if (cns.length) {
            for (var i = 0; i < cns.length; i++) {
                var cn = cns[i];
                o[cn] = o[cn] || {};
                o = o[cn];
            }
        }
        $.extend(true, o, data);
        if ($.isFunction(o.init)) {
            o.init.apply();
        }
    },
    applyIf : function() {
        var me = this, args = arguments, o = args[0] || {}, r = 1, i = 0;
        if ( typeof o == 'boolean' || typeof o == 'number') {
            r = o;
            i = 1;
            o = args[1];
        }
        for (; i < args.length; i++) {
            var c = args[i];
            for (var p in c) {
                if ( typeof o[p] == "undefined") {
                    o[p] = c[p];
                } else if ( typeof o[p] == "object" && r) {
                    if ( typeof r == 'number') {
                        r--;
                    }
                    me.applyIf(r, o[p], c[p]);
                }
            }
        }
        return o;
    }
};