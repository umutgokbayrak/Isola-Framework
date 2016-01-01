package isola.model.ext.visual;
 * // Init the singleton.  Any tag-based quick tips will start working.
 * Ext.QuickTips.init();
 * 
 * // Apply a set of config properties to the singleton
 * Ext.apply(Ext.QuickTips.getQuickTip(), {
 *   maxWidth: 200,
 *   minWidth: 100,
 *   showDelay: 50,
 *   trackMouse: true
 * });
 * 
 * // Manually register a quick tip for a specific element
 * q.register({
 *   target: 'my-div',
 *   title: 'My Tooltip',
 *   text: 'This tooltip was added in code',
 *   width: 100,
 *   dismissDelay: 20
 * });
 * &lt;/code&gt;
 * // Add a quick tip to an HTML button
 * &lt;input type=&quot;button&quot; value=&quot;OK&quot; ext:qtitle=&quot;OK Button&quot; ext:qwidth=&quot;100&quot;
 *    ext:qtip=&quot;This is a quick tip from markup!&quot;&gt;&lt;/input&gt;
 * &lt;/code&gt;