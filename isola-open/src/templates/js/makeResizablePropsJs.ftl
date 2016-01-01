<#if containerId??>
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
	</#if>