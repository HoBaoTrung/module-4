
$(document).ready(function () {
    i18n.load('en', i18n.apply);

    $('#lang-select').on('change', function () {
        const lang = $(this).val();
        localStorage.setItem('lang', lang);
        i18n.changeLang(lang);
    });
});



var i18n = (function () {
    const STORAGE_PREFIX = 'i18n_';
    let currentLang = 'en';
    let messages = {};

    function load(lang, callback) {
        const cached = localStorage.getItem(STORAGE_PREFIX + lang);
        if (cached) {
            messages = JSON.parse(cached);
            currentLang = lang;
            if (callback) callback();
        } else {
            $.get('http://localhost:8080/api/i18n?lang=' + lang, function (data) {
                messages = data;
                currentLang = lang;
                localStorage.setItem(STORAGE_PREFIX + lang, JSON.stringify(data));
                if (callback) callback();
            });
        }
    }

    function get(key) {
        return messages[key] || key;
    }

    function apply() {
        // Tự cập nhật tất cả thẻ có data-i18n="key"
        $('[data-i18n]').each(function () {
            const key = $(this).attr('data-i18n');
            const val = get(key);

            if (this.tagName === 'INPUT' || this.tagName === 'TEXTAREA') {
                if (this.type === 'submit' || this.type === 'button') {
                    $(this).val(val);
                } else {
                    $(this).attr('placeholder', val);
                }
            } else if (this.tagName === 'TITLE') {
                document.title = val;
            } else {
                $(this).text(val);
            }
        });
    }

    function changeLang(lang, callback) {
        load(lang, function () {
            apply();
            if (callback) callback();
        });
    }

    return {
        load: load,
        get: get,
        apply: apply,
        changeLang: changeLang,
        currentLang: () => currentLang
    };
})();
