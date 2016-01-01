<script type="text/javascript" src="${jsPath!''}/extjs/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="${jsPath!''}/extjs/ext-all.js"></script>
<script type="text/javascript" src="${jsPath!''}/extjs/ux/ext-ux.js"></script>
<#if lang??><script type="text/javascript" src="${jsPath!''}/extjs/build/locale/ext-lang-${lang}-min.js"></script></#if>
<script type="text/javascript" src="${jsPath!''}/mootools.js"></script>
<script type="text/javascript">
	var contextRoot = '${contextRoot}';
	Ext.onReady(function() {
		Ext.BLANK_IMAGE_URL = '${jsPath!''}/extjs/resources/images/default/s.gif';
		Ext.QuickTips.init();
	});
</script>
<link rel="stylesheet" type="text/css" href="${jsPath!''}/extjs/resources/css/ext-all.css">
<link rel="stylesheet" type="text/css" href="${jsPath!''}/extjs/ux/ext-ux.css">
<link rel="stylesheet" type="text/css" href="${cssPath!''}/base.css">
<#if theme??><link rel="stylesheet" type="text/css" href="${jsPath!''}/extjs/resources/css/xtheme-${theme!}.css"></#if>
