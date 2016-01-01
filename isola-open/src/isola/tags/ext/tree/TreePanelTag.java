package isola.tags.ext.tree;
 * &lt;ext:body runOnLoad=&quot;true&quot;&gt;
 * 	&lt;ext:borderLayout renderTo=&quot;hebelek&quot; border=&quot;true&quot; width=&quot;900&quot; height=&quot;600&quot;&gt;
 * 		&lt;ext:treePanel rootVisible=&quot;true&quot; lines=&quot;true&quot; region=&quot;west&quot; split=&quot;true&quot; width=&quot;200&quot; autoScroll=&quot;true&quot; animate=&quot;true&quot; enableDD=&quot;true&quot; title=&quot;Folder Tree&quot;&gt;
 * 			&lt;ext:asyncTreeNode text=&quot;Root Node&quot; id=&quot;source&quot; draggable=&quot;false&quot; /&gt;
 * 			&lt;ext:treeLoader url=&quot;servlet/TreeLoaderServlet&quot; method=&quot;post&quot; /&gt;
 * 		&lt;/ext:treePanel&gt;
 * 		&lt;ext:borderLayout region=&quot;center&quot; split=&quot;true&quot;&gt;
 * 			&lt;ext:gridPanel region=&quot;north&quot; height=&quot;300&quot; forceFit=&quot;true&quot; border=&quot;true&quot; checkboxEnabled=&quot;true&quot;&gt;
 * 				&lt;ext:jsonStore url=&quot;servlet/JsonSampleServlet&quot; root=&quot;result&quot;&gt;
 * 					&lt;ext:httpParam name=&quot;action&quot; value=&quot;env&quot;/&gt;
 * 					&lt;ext:storeMapping name=&quot;name&quot;/&gt;
 * 					&lt;ext:storeMapping name=&quot;value&quot;/&gt;
 * 				&lt;/ext:jsonStore&gt;
 * 				&lt;ext:columnModel&gt;
 * 					&lt;ext:gridColumn dataIndex=&quot;name&quot; header=&quot;Name&quot; /&gt;
 * 					&lt;ext:gridColumn dataIndex=&quot;value&quot; header=&quot;Value&quot; /&gt;
 * 				&lt;/ext:columnModel&gt;
 * 			&lt;/ext:gridPanel&gt;
 * 			&lt;ext:borderLayout region=&quot;center&quot; split=&quot;true&quot; border=&quot;false&quot;&gt;
 * 				&lt;ext:panel region=&quot;north&quot; height=&quot;40&quot; bodyStyle=&quot;background-color:#f8f8f8;&quot; contentEl=&quot;msgHead&quot; style=&quot;border-top: 1px solid #eeeeee; border-bottom:1px solid #eeeeee;&quot;&gt;
 * 				&lt;/ext:panel&gt;
 * 				&lt;ext:panel region=&quot;center&quot; split=&quot;true&quot; border=&quot;true&quot;&gt;
 * 					This is the center pane
 * 				&lt;/ext:panel&gt;
 * 			&lt;/ext:borderLayout&gt;
 * 		&lt;/ext:borderLayout&gt;
 * 	&lt;/ext:borderLayout&gt;
 * &lt;/ext:body&gt;
 * 
 * &lt;div id=&quot;hebelek&quot;&gt;&lt;/div&gt;
 * 
 * &lt;div id=&quot;msgHead&quot;&gt;
 * 	&lt;b&gt;From:&lt;/b&gt;Test User&lt;br/&gt;
 * 	&lt;b&gt;Subject:&lt;/b&gt;Test Subject
 * &lt;/div&gt;
 * &lt;/code&gt;
	 * target - The node being targeted for the drop
	 * data - The drag data from the drag source
	 * point - The point of the drop - append, above or below
	 * source - The drag source
	 * rawEvent - Raw mouse event
	 * dropNode - Drop node(s) provided by the source &lt;strong&gt;OR&lt;/strong&gt; you can supply node(s) to be inserted by setting them on this object.
	 * cancel - Set this to true to cancel the drop.
	 * dropStatus - If the default drop action is cancelled but the drop is valid, setting this to true will prevent the animated &quot;repair&quot; from appearing.
	 * target - The node being targeted for the drop
	 * data - The drag data from the drag source
	 * point - The point of the drop - append, above or below
	 * source - The drag source
	 * rawEvent - Raw mouse event
	 * dropNode - Drop node(s) provided by the source.
	 * cancel - Set this to true to signal drop not allowed.
	 * target - The node being targeted for the drop
	 * data - The drag data from the drag source
	 * point - The point of the drop - append, above or below
	 * source - The drag source
	 * rawEvent - Raw mouse event
	 * dropNode - Dropped node(s).