package isola.model.ext.layout;
 * var navHandler = function(direction){
 *     // This routine could contain business logic required to manage the navigation steps.
 *     // It would call setActiveItem as needed, manage navigation button state, handle any
 *     // branching logic that might be required, handle alternate actions like cancellation
 *     // or finalization, etc.  A complete wizard implementation could get pretty
 *     // sophisticated depending on the complexity required, and should probably be
 *     // done as a subclass of CardLayout in a real-world implementation.
 * };
 * 
 * var card = new Ext.Panel({
 *     title: 'Example Wizard',
 *     layout:'card',
 *     activeItem: 0, // make sure the active item is set on the container config!
 *     bodyStyle: 'padding:15px',
 *     defaults: {
 *         // applied to each contained panel
 *         border:false
 *     },
 *     // just an example of one possible navigation scheme, using buttons
 *     bbar: [
 *         {
 *             id: 'move-prev',
 *             text: 'Back',
 *             handler: navHandler.createDelegate(this, [-1]),
 *             disabled: true
 *         },
 *         '-&gt;', // greedy spacer so that the buttons are aligned to each side
 *         {
 *             id: 'move-next',
 *             text: 'Next',
 *             handler: navHandler.createDelegate(this, [1])
 *         }
 *     ],
 *     // the panels (or &quot;cards&quot;) within the layout
 *     items: [{
 *         id: 'card-0',
 *         html: '&lt;h1&gt;Welcome to the Wizard!&lt;/h1&gt;&lt;p&gt;Step 1 of 3&lt;/p&gt;'
 *     },{
 *         id: 'card-1',
 *         html: '&lt;p&gt;Step 2 of 3&lt;/p&gt;'
 *     },{
 *         id: 'card-2',
 *         html: '&lt;h1&gt;Congratulations!&lt;/h1&gt;&lt;p&gt;Step 3 of 3 - Complete&lt;/p&gt;'
 *     }]
 * });
 * &lt;/code&gt;