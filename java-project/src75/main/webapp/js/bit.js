//bit.js
var bit = (selector) => {
    var el;
    
    if (typeof(selector) == 'function') {
        return selector();
    } else if (selector instanceof HTMLElement) {
        el = [selector];
    } else if (selector.indexOf('<') != -1) {
        el = [document.createElement(selector.substr(1, selector.length - 2))];
    } else {
        el = document.querySelectorAll(selector);
    }
    
    // 준비한 엘리먼트에 도우미 함수를 추가한다.
    el.html = (value) => {
        for (var i = 0; i < el.length; i++) {
            el[i].innerHTML = value;
        }
        return el;
    };
    
    el.click = (cb) => {
        for (var i = 0; i < el.length; i++) {
            el[i].onclick = cb;
        }
        return el;
    };
    
    el.append = (childs) => {
        for (var i = 0; i < childs.length; i++) {
            el[el.length - 1].appendChild(childs[i]);
        }
        return el;
    };
    
    el.appendTo = (parents) => {
        for (var i = 0; i < el.length; i++) {
            parents[parents.length - 1].appendChild(el[i]);
        }
        return el;
    };
    
    el.addClass = (classname) => {
        for (var i = 0; i < el.length; i++) {
            var arr = el[i].className.split(" ");
            arr.push(classname);
            el[i].className = arr.join(' ');
        }
        return el;
    };
    
    el.removeClass = (classname) => {
        for (var i = 0; i < el.length; i++) {
            el[i].className = el[i].className.split(classname).join(' ');
        }
        return el;
    };
    
    el.css = (name, value) => {
        for (var i = 0; i < el.length; i++) {
            el[i].style[name] = value;
        }
        return el;
    };
    
    el.parent = () => {
        return el[0].parentNode;
    };
    
    el.val = (value) => {
        if (value == undefined) {
            return el[0].value;
        }
        
        for (var i = 0; i < el.length; i++) {
            el[i].value = value;
        }
        return el;
    };
    
    return el;
};

bit.toQueryString = (obj) => {
    var qs = '';
    for (var propName in obj) {
        if (qs.length > 0) qs += '&';
        
        qs += propName + '=' + obj[propName]
    }
    return qs;
};

bit.ajax = (url, settings) => {
    
    if (settings == undefined) settings = {};
    if (settings.method == undefined) settings.method = 'GET';
    if (settings.data == undefined) settings.data = {};
    if (settings.dataType == undefined) settings.dataType = 'text';
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState < 4) return;
        if (xhr.status != 200) {
            if (settings.error) {
                settings.error();
            }
            return;
        }
        
        if (settings.success) {
            if (settings.dataType == 'json') {
                settings.success(JSON.parse(xhr.responseText));
            } else {
                settings.success(xhr.responseText);
            }
        }
    };
    
    if (settings.method.toUpperCase() == 'POST') {
        xhr.open(settings.method, url, true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send(bit.toQueryString(settings.data));
        
    } else { // GET, HEAD 요청
        xhr.open(
            settings.method, 
            url + '?' + bit.toQueryString(settings.data), 
            true);
        xhr.send();
    }
};


var $ = bit;










