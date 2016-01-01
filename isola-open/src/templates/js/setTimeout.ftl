${jsFunction}.delay(${delay}, <#if bind??>$(${bind})<#else>null</#if>, [<#if args??><#list args as arg>${arg}<#if args?last != arg>,</#if></#list></#if>]);
