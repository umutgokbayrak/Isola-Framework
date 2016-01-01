/**
 * List compiled by mystix on the extjs.com forums.
 * Thank you Mystix!
 *
 * Turkish translation by Alper YAZGAN
 * 2008-01-24 , 10:29 AM 
*/

Ext.UpdateManager.defaults.indicatorText = '<div class="loading-indicator">Y&#252;kleniyor ...</div>';

if(Ext.View){
  Ext.View.prototype.emptyText = "";
}

if(Ext.grid.GridPanel){
  Ext.grid.GridPanel.prototype.ddText = "Se&#231;ili sat&#305;r say&#305;s&#305; : {0}";
}

if(Ext.TabPanelItem){
  Ext.TabPanelItem.prototype.closeText = "Sekmeyi kapat";
}

if(Ext.form.Field){
  Ext.form.Field.prototype.invalidText = "Bu alandaki de&#287;er ge&#231;ersiz";
}

if(Ext.LoadMask){
  Ext.LoadMask.prototype.msg = "Y&#252;kleniyor ...";
}

Date.monthNames = [
  "Ocak",
  "&#350;ubat",
  "Mart",
  "Nisan",
  "May&#305;s",
  "Haziran",
  "Temmuz",
  "A&#287;ustos",
  "Eyl&#252;l",
  "Ekim",
  "Kas&#305;m",
  "Aral&#305;k"
];

Date.getShortMonthName = function(month) {
  return Date.monthNames[month].substring(0, 3);
};

Date.monthNumbers = {
  Jan : 0,
  Feb : 1,
  Mar : 2,
  Apr : 3,
  May : 4,
  Jun : 5,
  Jul : 6,
  Aug : 7,
  Sep : 8,
  Oct : 9,
  Nov : 10,
  Dec : 11
};

Date.getMonthNumber = function(name) {
  return Date.monthNumbers[name.substring(0, 1).toUpperCase() + name.substring(1, 3).toLowerCase()];
};

Date.dayNames = [
  "Pazar",
  "Pazartesi",
  "Sal&#305;",
  "&#199;ar&#351;amba",
  "Per&#351;embe",
  "Cuma",
  "Cumartesi"
];

Date.shortDayNames = [
  "Paz",
  "Pzt",
  "Sal",
  "&#199;r&#351;",
  "Pr&#351;",
  "Cum",
  "Cmt"
];

Date.getShortDayName = function(day) {
  return Date.shortDayNames[day];
};

if(Ext.MessageBox){
  Ext.MessageBox.buttonText = {
    ok     : "Tamam",
    cancel : "&#304;ptal",
    yes    : "Evet",
    no     : "Hay&#305;r"
  };
}

if(Ext.util.Format){
  Ext.util.Format.date = function(v, format){
    if(!v) return "";
    if(!(v instanceof Date)) v = new Date(Date.parse(v));
    return v.dateFormat(format || "d/m/Y");
  };
}

if(Ext.DatePicker){
  Ext.apply(Ext.DatePicker.prototype, {
    todayText         : "Bug&#252;n",
    minText           : "Bu tarih izin verilen en k&#252;&#231;&#252;k tarihten daha &#246;nce",
    maxText           : "Bu tarih izin verilen en b&#252;y&#252;k tarihten daha sonra",
    disabledDaysText  : "",
    disabledDatesText : "",
    monthNames        : Date.monthNames,
    dayNames          : Date.dayNames,
    nextText          : 'Gelecek Ay (Control+Right)',
    prevText          : '&#214;nceki Ay (Control+Left)',
    monthYearText     : 'Bir ay &#351;e&#231;iniz (Y&#305;l&#305; art&#305;rmak/azaltmak i&#231;in Control+Up/Down)',
    todayTip          : "{0} (Bo&#351;luk Tu&#351;u - Spacebar)",
    format            : "d/m/Y",
    okText            : "&#160;Tamam&#160;",
    cancelText        : "&#304;ptal",
    startDay          : 1
  });
}

if(Ext.PagingToolbar){
  Ext.apply(Ext.PagingToolbar.prototype, {
    beforePageText : "Sayfa",
    afterPageText  : " / {0}",
    firstText      : "&#304;lk Sayfa",
    prevText       : "&#214;nceki Sayfa",
    nextText       : "Sonraki Sayfa",
    lastText       : "Son Sayfa",
    refreshText    : "Yenile",
    displayMsg     : "G&#246;sterilen {0} - {1} / {2}",
    emptyMsg       : 'G&#246;sterilebilecek veri yok'
  });
}

if(Ext.form.TextField){
  Ext.apply(Ext.form.TextField.prototype, {
    minLengthText : "Girilen verinin uzunlu&#287;u en az {0} olabilir",
    maxLengthText : "Girilen verinin uzunlu&#287;u en fazla {0} olabilir",
    blankText     : "Bu alan bo&#351; b&#305;rak&#305;lamaz",
    regexText     : "",
    emptyText     : null
  });
}

if(Ext.form.NumberField){
  Ext.apply(Ext.form.NumberField.prototype, {
    minText : "En az {0} girilebilir",
    maxText : "En &#231;ok {0} girilebilir",
    nanText : "{0} ge&#231;ersiz bir say&#305;d&#305;r"
  });
}

if(Ext.form.DateField){
  Ext.apply(Ext.form.DateField.prototype, {
    disabledDaysText  : "Aktif Degil",
    disabledDatesText : "Aktif Degil",
    minText           : "Bu tarih, {0} tarihinden daha sonra olmal&#305;d&#305;r", 
    maxText           : "Bu tarih, {0} tarihinden daha &#246;nce olmal&#305;d&#305;r",
    invalidText       : "{0} ge&#231;ersiz bir tarihdir - tarih format&#305; {1} &#351;eklinde olmal&#305;d&#305;r",
    format            : "d/m/Y",
    altFormats        : "d.m.y|d.m.Y|d/m/y|d-m-Y|d-m-y|d.m|d/m|d-m|dm|dmY|dmy|d|Y.m.d|Y-m-d|Y/m/d"
  });
}

if(Ext.form.ComboBox){
  Ext.apply(Ext.form.ComboBox.prototype, {
    loadingText       : "Y&#252;kleniyor ...",
    valueNotFoundText : undefined
  });
}

if(Ext.form.VTypes){
  Ext.apply(Ext.form.VTypes, {
    emailText    : 'Bu alan "user@domain.com" &#351;eklinde elektronik posta format&#305;nda olmal&#305;d&#305;r',
    urlText      : 'Bu alan "http://www.domain.com" &#351;eklinde URL adres format&#305;nda olmal&#305;d&#305;r',
    alphaText    : 'Bu alan sadece harf ve _ i&#231;ermeli',
    alphanumText : 'Bu alan sadece harf, say&#305; ve _ i&#231;ermeli'
  });
}

if(Ext.form.HtmlEditor){
  Ext.apply(Ext.form.HtmlEditor.prototype, {
    createLinkText : 'L&#252;tfen bu ba&#287;lant&#305; i&#231;in gerekli URL adresini giriniz:',
    buttonTips : {
      bold : {
        title: 'Kal&#305;n(Bold) (Ctrl+B)',
        text: '&#350;e&#231;ili yaz&#305;y&#305; kal&#305;n yapar.',
        cls: 'x-html-editor-tip'
      },
      italic : {
        title: '&#304;talik(Italic) (Ctrl+I)',
        text: '&#350;e&#231;ili yaz&#305;y&#305; italik yapar.',
        cls: 'x-html-editor-tip'
      },
      underline : {
        title: 'Alt &#199;izgi(Underline) (Ctrl+U)',
        text: '&#350;e&#231;ili yaz&#305;n&#305;n alt&#305;n&#305; &#231;izer.',
        cls: 'x-html-editor-tip'
      },
      increasefontsize : {
        title: 'Fontu b&#252;y&#252;lt',
        text: 'Yaz&#305; fontunu b&#252;y&#252;t&#252;r.',
        cls: 'x-html-editor-tip'
      },
      decreasefontsize : {
        title: 'Fontu k&#252;&#231;&#252;lt',
        text: 'Yaz&#305; fontunu k&#252;&#231;&#252;lt&#252;r.',
        cls: 'x-html-editor-tip'
      },
      backcolor : {
        title: 'Arka Plan Rengi',
        text: 'Se&#231;ili yaz&#305;n&#305;n arka plan rengini de&#287;i&#351;tir.',
        cls: 'x-html-editor-tip'
      },
      forecolor : {
        title: 'Yaz&#305; Rengi',
        text: 'Se&#231;ili yaz&#305;n&#305;n rengini de&#287;i&#351;tir.',
        cls: 'x-html-editor-tip'
      },
      justifyleft : {
        title: 'Sola Daya',
        text: 'Yaz&#305;y&#305; sola daya.',
        cls: 'x-html-editor-tip'
      },
      justifycenter : {
        title: 'Ortala',
        text: 'Yaz&#305;y&#305; edit&#246;rde ortala.',
        cls: 'x-html-editor-tip'
      },
      justifyright : {
        title: 'Sa&#287;a daya',
        text: 'Yaz&#305;y&#305; sa&#287;a daya.',
        cls: 'x-html-editor-tip'
      },
      insertunorderedlist : {
        title: 'Noktal&#305; Liste',
        text: 'Noktal&#305; listeye ba&#351;la.',
        cls: 'x-html-editor-tip'
      },
      insertorderedlist : {
        title: 'Numaral&#305; Liste',
        text: 'Numaral&#305; lisyeye ba&#351;la.',
        cls: 'x-html-editor-tip'
      },
      createlink : {
        title: 'Web Adresi(Hyperlink)',
        text: 'Se&#231;ili yaz&#305;y&#305; web adresi(hyperlink) yap.',
        cls: 'x-html-editor-tip'
      },
      sourceedit : {
        title: 'Kaynak kodu D&#252;zenleme',
        text: 'Kaynak kodu d&#252;zenleme moduna ge&#231;.',
        cls: 'x-html-editor-tip'
      }
    }
  });
}

if(Ext.grid.GridView){
  Ext.apply(Ext.grid.GridView.prototype, {
    sortAscText  : "Artan s&#305;rada s&#305;rala",
    sortDescText : "Azalan s&#305;rada s&#305;rala",
    lockText     : "Kolonu kilitle",
    unlockText   : "Kolon kilidini kald&#305;r",
    columnsText  : "Kolonlar"
  });
}

if(Ext.grid.GroupingView){
  Ext.apply(Ext.grid.GroupingView.prototype, {
    emptyGroupText : '(Yok)',
    groupByText    : 'Bu Alana G&#246;re Grupla',
    showGroupsText : 'Gruplar Halinde G&#246;ster'
  });
}

if(Ext.grid.PropertyColumnModel){
  Ext.apply(Ext.grid.PropertyColumnModel.prototype, {
    nameText   : "Ad",
    valueText  : "De&#287;er",
    dateFormat : "d/m/Y"
  });
}

if(Ext.layout.BorderLayout && Ext.layout.BorderLayout.SplitRegion){
  Ext.apply(Ext.layout.BorderLayout.SplitRegion.prototype, {
    splitTip            : "Yeniden boyutland&#305;rmak i&#231;in s&#252;r&#252;kle.",
    collapsibleSplitTip : "Yeniden boyutland&#305;rmak i&#231;in s&#252;r&#252;kle. Saklamak i&#231;in &#231;ift t&#305;kla."
  });
}
