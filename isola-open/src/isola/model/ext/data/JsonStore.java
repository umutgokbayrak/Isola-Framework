package isola.model.ext.data;
 * var store = new Ext.data.JsonStore({
 *   url: 'get-images.php',
 *   root: 'images',
 *   fields: ['name', 'url', {name:'size', type: 'float'}, {name:'lastmod', type:'date'}]
 * });
 * &lt;/code&gt;
 * {
 *   images: [
 *       {name: 'Image one', url:'/GetImage.php?id=1', size:46.5, lastmod: new Date(2007, 10, 29)},
 *       {name: 'Image Two', url:'/GetImage.php?id=2', size:43.2, lastmod: new Date(2007, 10, 30)}
 *   ]
 * }
 * &lt;/code&gt;