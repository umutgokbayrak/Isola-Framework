package isola.model.ext.data;
 * boolean scriptTag = false;
 * String cb = request.getParameter(&quot;callback&quot;);
 * if (cb != null) {
 *     scriptTag = true;
 *     response.setContentType(&quot;text/javascript&quot;);
 * } else {
 *     response.setContentType(&quot;application/x-json&quot;);
 * }
 * Writer out = response.getWriter();
 * if (scriptTag) {
 *     out.write(cb + &quot;(&quot;);
 * }
 * out.print(dataBlock.toJsonString());
 * if (scriptTag) {
 *     out.write(&quot;);&quot;);
 * }
 * &lt;/code&gt;