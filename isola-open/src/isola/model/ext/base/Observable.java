package isola.model.ext.base;import isola.model.core.JsArray;import isola.model.core.JsFunction;import isola.model.core.JsObject;/** *  * Abstract base class that provides a common interface for publishing events. * Subclasses are *  * expected to to have a property "events" with all the events defined. *  * For example: *  *  *  * Employee = function(name){ *  * this.name = name; *  * this.addEvents({ *  * "fired" : true, *  * "quit" : true *  * }); *  * } *  * Ext.extend(Employee, Ext.util.Observable); *  *  *  * @author Umut Gokbayrak *  *  */public class Observable extends JsObject {	private static final long serialVersionUID = -1847826612544531689L;	/**	 * 	 * A config object containing one or more event handlers to be added	 * 	 * to this object during initialization. This should be a valid listeners	 * 	 * config object as specified in the addListener example for attaching	 * 	 * multiple handlers at once.	 */	public JsObject listeners = new JsObject();		public Observable() {		super();	}		/**	 * 	 * Returns a Javascript Object with listeners defined.	 * 	 * 	 * 	 * @return {@link JsObject}	 */	public JsObject getListeners() {		return listeners;	}		/**	 * 	 * A config object containing one or more event handlers to be added to this	 * object during	 * 	 * initialization. This should be a valid listeners config object as	 * specified in the	 * 	 * addListener example for attaching multiple handlers at once.	 * 	 * 	 * 	 * The JsObject consists of EventFunctionPairs with the following syntax. Or	 * you can use the addListeners	 * 	 * instead.	 * 	 * 	 * 	 * <pre>	 * 	 * 'click' : {	 * 
	 *   fn: this.onClick,	 * 
	 *   scope: this,	 * 
	 *   delay: 100	 * 
	 *  }, 	 * 
	 *  'mouseover' : {	 * 
	 *   fn: this.onMouseOver,	 * 
	 *   scope: this	 * 
	 *  },	 * 
	 *  'mouseout' : {	 * 
	 *   fn: this.onMouseOut,	 * 
	 *   scope: this	 * 
	 *  }	 * 
	 * }	 * 	 * </pre>	 * 	 * 	 * 	 * @param listeners	 */	public void setListeners(JsObject listeners) {		this.listeners = listeners;	}		/**	 * 	 * Appends an event handler to this component	 * 	 * Options may be one of the following JsObjectPairs:	 * 	 * scope : Object	 * 	 * The scope in which to execute the handler function. The handler	 * function's "this" context.	 * 	 * delay : Number	 * 	 * 	 * 	 * The number of milliseconds to delay the invocation of the handler after	 * the event fires.	 * 	 * single : Boolean	 * 	 * 	 * 	 * True to add a handler to handle just the next firing of the event, and	 * then remove itself.	 * 	 * buffer {Number} Causes the handler to be scheduled to run in an	 * Ext.util.DelayedTask delayed by the specified number of milliseconds. If	 * the event fires again within that time, the original handler is not	 * invoked, but the new handler is scheduled in its place.	 * 	 * 	 * 	 * @param eventName	 *            The type of event to listen for (ex: onclick, onfocus etc...)	 * 	 * @param handler	 *            The method the event invokes	 * 	 * @param scope	 *            (optional) The scope in which to execute the handler function.	 *            The handler function's "this" context.	 * 	 * @param options	 *            (optional) An object containing handler configuration	 *            properties.	 */	public void addListener(String eventName, JsFunction handler, String scope, JsObject options) {		if (eventName == null)			return;		if (eventName.startsWith("on")) {			eventName = eventName.substring(2);		}		// get the listeners object		if (listeners == null) {			listeners = new JsObject();		}		JsObject item = new JsObject();		// prepare the handler		if (handler == null) {			handler = new JsFunction(JsFunction.FUNCTION, "this." + eventName);		}		item.put("fn", handler.toString());		// prepare the scope		if (scope == null) {			scope = "this";		}		item.put("scope", scope);		// if another options exist append em.		if (options != null) {			item.putAll(options);		}		// store listeners back		listeners.put(eventName, item);	}		/**	 * 	 * Shorthand for addListener	 * 	 * 	 * 	 * @see Observable#addListener(String, JsFunction, String, JsObject)	 * 	 * @param eventName	 * 	 * @param handler	 * 	 * @param scop	 * 	 * @param options	 */	public void on(String eventName, JsFunction handler, String scope, JsObject options) {		addListener(eventName, handler, scope, options);	}		/**	 * 	 * Removes all listeners for this object	 */	public void purgeListeners() {		this.listeners = null;	}		/**	 * 	 * Removes a listener	 * 	 * 	 * 	 * @param eventName	 */	public void removeListener(String eventName) {		if (eventName == null)			return;		if (eventName.startsWith("on")) {			eventName = eventName.substring(2);		}		// get the listeners object and remove the event		if (listeners == null) {			return;		}		listeners.remove(eventName);	}		/**	 * 	 * Shorthand for removeListener	 * 	 * 	 * 	 * @see Observable#removeListener(String, JsFunction, String)	 * 	 * @param eventName	 */	public void un(String eventName) {		removeListener(eventName);	}		/**	 * 	 * Used to define events on this Observable	 * 	 * 	 * 	 * @param events	 */	public void addEvents(Object events) {		String str = null;		if (events != null) {			if (events instanceof JsArray) {				str = ((JsArray) events).toString();			} else if (events instanceof JsFunction) {				str = ((JsFunction) events).toString();			} else if (events instanceof JsObject) {				str = ((JsObject) events).toString();			} else {				try {					str = events.toString();				} catch (Throwable t) {					return;				}			}			put("events", str);		}	}		protected void _postProcessToString() {		if (listeners.size() > 0)			put("listeners", listeners);	}		@Override	public String toString() {		return super.toString();	}}