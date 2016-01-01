<#if containerId??>	<#if containerId[0] == '$'>		<#if containerId[1..] == 'document'>
			var containerObj = ${containerId[1..]}.documentElement;
		<#else>
			var containerObj = ${containerId[1..]};
		</#if>
	<#else>
		var containerObj = document.getElementById('${containerId}');
	</#if>
</#if>
<#if limitX?? || limitY??>
var limit = {};
</#if>
<#if limitX??>
limit['x'] = [<#list limitX as lx>${lx}<#if limitX?last != lx>,</#if></#list>];
</#if>
<#if limitX??>
limit['y'] = [<#list limitY as ly>${ly}<#if limitY?last != ly>,</#if></#list>];
</#if>
var resizeOptions${elementId} = {
	<#if handleId??>
	handle: $('${handleId}'),
	</#if>	<#if snap??>	snap: ${snap},	</#if>	<#if grid??>	grid: ${grid},	</#if>	<#if onStart??>	onStart: function() {		${onStart}	},	</#if>	<#if onComplete??>	onComplete: function() {		${onComplete}	},	</#if>	<#if onDrag??>	onDrag: function() {		${onDrag}	},	</#if>	<#if limitX?? || limitY??>	limit: limit,	</#if>	modifiers: {		x: '${modifierX}', 		y: '${modifierY}'	}};$('${elementId}').makeDraggable(resizeOptions${elementId});