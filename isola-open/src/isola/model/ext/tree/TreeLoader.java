package isola.model.ext.tree;
 * [{
 *       id: 1,
 *       text: 'A leaf Node',
 *       leaf: true
 *   },{
 *       id: 2,
 *       text: 'A folder Node',
 *       children: [{
 *           id: 3,
 *           text: 'A child Node',
 *           leaf: true
 *       }]
 * }]
 * &lt;/code&gt;
 * myTreeLoader.on(&quot;beforeload&quot;, function(treeLoader, node) {
 *       this.baseParams.category = node.attributes.category;
 *   }, this);
 * &lt;/code&gt;