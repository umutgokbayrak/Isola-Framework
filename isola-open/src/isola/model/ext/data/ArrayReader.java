package isola.model.ext.data;
 * var Employee = Ext.data.Record.create([
 *   {name: 'name', mapping: 1},         // &quot;mapping&quot; only needed if an &quot;id&quot; field is present which
 *   {name: 'occupation', mapping: 2}    // precludes using the ordinal position as the index.
 * ]);
 * 
 * var myReader = new Ext.data.ArrayReader({
 *   id: 0                     // The subscript within row Array that provides an ID for the Record (optional)
 * }, Employee);
 * &lt;/code&gt;