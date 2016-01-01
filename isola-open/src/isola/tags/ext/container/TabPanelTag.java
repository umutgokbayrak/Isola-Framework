package isola.tags.ext.container;
 * var tabs = new Ext.TabPanel({
 *     renderTo: Ext.getBody(),
 *     activeTab: 0,
 *     items: [{
 *         title: 'Tab 1',
 *         html: 'A simple tab'
 *     },{
 *         title: 'Tab 2',
 *         html: 'Another one'
 *     }]
 * });
 * &lt;/code&gt;
 * var tabs = new Ext.TabPanel({
 *     renderTo: 'my-tabs',
 *     activeTab: 0,
 *     items:[
 *         {contentEl:'tab1', title:'Tab 1'},
 *         {contentEl:'tab2', title:'Tab 2'}
 *     ]
 * });
 * // Note that the tabs do not have to be nested within the container (although they can be)
 * &lt;div id=&quot;my-tabs&quot;&gt;&lt;/div&gt;
 * &lt;div id=&quot;tab1&quot; class=&quot;x-hide-display&quot;&gt;A simple tab&lt;/div&gt;
 * &lt;div id=&quot;tab2&quot; class=&quot;x-hide-display&quot;&gt;Another one&lt;/div&gt;
 * &lt;/code&gt;
	 * var tabs = new Ext.TabPanel({
	 *     applyTo: 'my-tabs',
	 *     activeTab: 0,
	 *     deferredRender: false,
	 *     autoTabs: true
	 * });
	 * 
	 * // This markup will be converted to a TabPanel from the code above
	 * &lt;div id=&quot;my-tabs&quot;&gt;
	 *     &lt;div class=&quot;x-tab&quot; title=&quot;Tab 1&quot;&gt;A simple tab&lt;/div&gt;
	 *     &lt;div class=&quot;x-tab&quot; title=&quot;Tab 2&quot;&gt;Another one&lt;/div&gt;
	 * &lt;/div&gt;
	 * &lt;/code&gt;