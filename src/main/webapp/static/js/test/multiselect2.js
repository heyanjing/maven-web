$(function () {
    //移到右边
    $('#add').click(function () {
        //获取选中的选项，删除并追加给对方
        $('#select1 option:selected').appendTo('#select2');
    });
    //移到左边
    $('#remove').click(function () {
        $('#select2 option:selected').appendTo('#select1');
    });
    //全部移到右边
    $('#add_all').click(function () {
        //获取全部的选项,删除并追加给对方
        $('#select1 option').appendTo('#select2');
    });
    //全部移到左边
    $('#remove_all').click(function () {
        $('#select2 option').appendTo('#select1');
    });
    //双击选项
    $('#select1').dblclick(function () { //绑定双击事件
        //获取全部的选项,删除并追加给对方
        $("option:selected", this).appendTo('#select2'); //追加给对方
    });
    //双击选项
    $('#select2').dblclick(function () {
        $("option:selected", this).appendTo('#select1');
    });
    var map=obj.Map.put(0,0).put(1,1).put(2,2);
    alert('map的大小为：'+map.size());
    for(var i=0;i<map.size();i++){
        alert('map的key'+i+'对应的value值为'+map.get(i));
    }
    alert('获取map中不存在的键'+map.get('获取map中不存在的键'));
    alert('map中的所有键的长度'+map.keys().length);
    for(var i=0;i<map.keys().lenght;i++){
        alert('map中的键值'+map.keys()[i]);
    }
    alert('map中的所有的value值的长度'+map.values().length);
    for(var i=0;i<map.values().length;i++){
        alert('map中的value的值'+map.values()[i]);
    }
    alert('判断map中的值value是否存在3'+map.containsValue(3));
});
(function () {
    console.log(111);
}());
(function () {
    console.log(222);
})();

var obj = {
    Map: {
        elements: [],
        size: function () {
            return this.elements.length;
        },
        isEmpty: function () {
            return (this.elements.length < 1);
        },
        clear: function () {
            this.elements = [];
        },
        element: function (_index) {
            if (_index < 0 || _index >= this.elements.length) {
                return null;
            }
            return this.elements[_index];
        },
        containsValue: function (_value) {
            var bln = false;
            try {
                for (var i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].value === _value) {
                        bln = true;
                    }
                }
            } catch (e) {
                bln = false;
            }
            return bln;
        },
        containsKey: function (_key) {
            var bln = false;
            try {
                for (var i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].key === _key) {
                        bln = true;
                    }
                }
            } catch (e) {
                bln = false;
            }
            return bln;
        },
        put: function (_key, _value) {
            if (this.containsKey(_key) === true) {
                if (this.containsValue(_value)) {
                    if (this.remove(_key) === true) {
                        this.elements.push({
                            key: _key,
                            value: _value
                        });
                    }
                } else {
                    this.elements.push({
                        key: _key,
                        value: _value
                    });
                }
            } else {
                this.elements.push({
                    key: _key,
                    value: _value
                });
            }
            return this;
        },
        remove: function (_key) {
            var bln = false;
            try {
                for (var i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].key === _key) {
                        this.elements.splice(i, 1);
                        return true;
                    }
                }
            } catch (e) {
                bln = false;
            }
            return bln;
        },
        get: function (_key) {
            try {
                for (var i = 0; i < this.elements.length; i++) {
                    if (this.elements[i].key === _key) {
                        return this.elements[i].value;
                    }
                }
            } catch (e) {
                return null;
            }
        },
        keys: function () {
            var arr = [];
            for (var i = 0; i < this.elements.length; i++) {
                arr.push(this.elements[i].key);
            }
            return arr;
        },
        values: function () {
            var arr = [];
            for (var i = 0; i < this.elements.length; i++) {
                arr.push(this.elements[i].value);
            }
            return arr;
        }
    }
}