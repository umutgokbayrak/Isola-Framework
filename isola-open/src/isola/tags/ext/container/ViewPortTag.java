package isola.tags.ext.container;
 * new Ext.Viewport({
 *     layout: 'border',
 *     defaults: {
 *         activeItem: 0
 *     },
 *     items: [{
 *         region: 'north',
 *         html: '&lt;h1 class=&quot;x-panel-header&quot;&gt;Page Title&lt;/h1&gt;',
 *         autoHeight: true,
 *         border: false,
 *         margins: '0 0 5 0'
 *     }, {
 *         region: 'west',
 *         collapsible: true,
 *         title: 'Navigation',
 *         xtype: 'treepanel',
 *         width: 200,
 *         autoScroll: true,
 *         split: true,
 *         loader: new Ext.tree.TreeLoader(),
 *         root: new Ext.tree.AsyncTreeNode({
 *             expanded: true,
 *             children: [{
 *                 text: 'Menu Option 1',
 *                 leaf: true
 *             }, {
 *                 text: 'Menu Option 2',
 *                 leaf: true
 *             }, {
 *                 text: 'Menu Option 3',
 *                 leaf: true
 *             }]
 *         }),
 *         rootVisible: false,
 *         listeners: {
 *             click: function(n) {
 *                 Ext.Msg.alert('Navigation Tree Click', 'You clicked: &quot;' + n.attributes.text + '&quot;');
 *             }
 *         }
 *     }, {
 *         region: 'center',
 *         xtype: 'tabpanel',
 *         items: {
 *             title: 'Default Tab',
 *             html: 'The first tab\'s content. Others may be added dynamically'
 *         }
 *     }, {
 *         region: 'south',
 *         title: 'Information',
 *         collapsible: true,
 *         html: 'Information goes here',
 *         split: true,
 *         height: 100,
 *         minHeight: 100
 *     }]
 * });
 * &lt;/code&gt;