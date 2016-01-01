package isola.model.ext.container;
 * var store = new Ext.data.JsonStore({
 *     url: 'get-images.php',
 *     root: 'images',
 *     fields: [
 *         'name', 'url',
 *         {name:'size', type: 'float'},
 *         {name:'lastmod', type:'date', dateFormat:'timestamp'}
 *     ]
 * });
 * store.load();
 * 
 * var tpl = new Ext.XTemplate(
 *     '&lt;tpl for=&quot;.&quot;&gt;',
 *         '&lt;div class=&quot;thumb-wrap&quot; id=&quot;{name}&quot;&gt;',
 *         '&lt;div class=&quot;thumb&quot;&gt;&lt;img src=&quot;{url}&quot; title=&quot;{name}&quot;&gt;&lt;/div&gt;',
 *         '&lt;span class=&quot;x-editable&quot;&gt;{shortName}&lt;/span&gt;&lt;/div&gt;',
 *     '&lt;/tpl&gt;',
 *     '&lt;div class=&quot;x-clear&quot;&gt;&lt;/div&gt;'
 * );
 * 
 * var panel = new Ext.Panel({
 *     id:'images-view',
 *     frame:true,
 *     width:535,
 *     autoHeight:true,
 *     collapsible:true,
 *     layout:'fit',
 *     title:'Simple DataView',
 * 
 *     items: new Ext.DataView({
 *         store: store,
 *         tpl: tpl,
 *         autoHeight:true,
 *         multiSelect: true,
 *         overClass:'x-view-over',
 *         itemSelector:'div.thumb-wrap',
 *         emptyText: 'No images to display'
 *     })
 * });
 * panel.render(document.body);
 * &lt;/code&gt;