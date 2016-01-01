package isola.tags.ext.form;

import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;

import isola.model.core.JsArray;
import isola.model.core.JsFunction;
import isola.model.ext.base.Observable;
import isola.model.ext.form.HtmlEditor;

/**
 * <p>Provides a lightweight HTML Editor component. </p>
 * 
 * <p>Note: The focus/blur and validation marking functionality inherited from Ext.form.Field 
 * is NOT supported by this editor. An Editor is a sensitive component that can't be used in 
 * all spots standard fields can be used. Putting an Editor within any element that has display 
 * set to 'none' can cause problems in Safari and Firefox due to their default iframe reloading 
 * bugs.</p>
 * 
 * @author Umut Gokbayrak
 */
public class HtmlEditorTag extends FieldTag {
	private static final long serialVersionUID = -6664093665410575423L;

	private String createLinkText;
	private String defaultLinkValue;
	private String enableAlignments;
	private String enableColors;
	private String enableFont;
	private String enableFontSize;
	private String enableFormat;
	private String enableLinks;
	private String enableLists;
	private String enableSourceEdit;
	private String fontFamilies;
	private String width;
	private String height;

	private String onActivate;
	private String onBeforePush;
	private String onBeforeSync;
	private String onEditModeChange;
	private String onInitialize;
	private String onPush;
	private String onSync;
	
	@Override
	public int doEndTag() throws JspException {
		HtmlEditor obj = new HtmlEditor();
		prepareConfig(obj);

		// manage listeners
		prepareEvents(obj);

		// print the output
		printOut(obj);

		return EVAL_PAGE;
	}

	@Override
	public void clear() {
		super.clear();
		createLinkText = defaultLinkValue = null;
		enableAlignments = enableColors = enableFont = enableFontSize = enableFormat = "true";
		enableLinks = enableLists = enableSourceEdit = "true";
		fontFamilies = null;
		onActivate = onBeforePush = onBeforeSync = onEditModeChange = null;
		onInitialize = onPush = onSync = null;
		width = height = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(HtmlEditor obj) {
		setHideLabel("true");
		super.prepareConfig(obj);

		obj.createLinkText = createLinkText;
		obj.defaultLinkValue = defaultLinkValue;
		
		if (enableAlignments != null) {
			try {
				obj.enableAlignments = Boolean.valueOf(enableAlignments);
			} catch (Exception e) {}
		}

		if (enableColors != null) {
			try {
				obj.enableColors = Boolean.valueOf(enableColors);
			} catch (Exception e) {}
		}

		if (enableFont != null) {
			try {
				obj.enableFont = Boolean.valueOf(enableFont);
			} catch (Exception e) {}
		}

		if (enableFontSize != null) {
			try {
				obj.enableFontSize = Boolean.valueOf(enableFontSize);
			} catch (Exception e) {}
		}

		if (enableFormat != null) {
			try {
				obj.enableFormat = Boolean.valueOf(enableFormat);
			} catch (Exception e) {}
		}

		if (enableLinks != null) {
			try {
				obj.enableLinks = Boolean.valueOf(enableLinks);
			} catch (Exception e) {}
		}

		if (enableLists != null) {
			try {
				obj.enableLists = Boolean.valueOf(enableLists);
			} catch (Exception e) {}
		}

		if (enableSourceEdit != null) {
			try {
				obj.enableSourceEdit = Boolean.valueOf(enableSourceEdit);
			} catch (Exception e) {}
		}

		if (fontFamilies != null) {
			StringTokenizer token = new StringTokenizer(fontFamilies, "|");
			JsArray arr = new JsArray();
			while (token.hasMoreTokens()) {
				String tmp = token.nextToken();
				arr.add(tmp);
			}
			obj.fontFamilies = arr;
		}
		
		if (width != null) {
			obj.width = width;
		} else {
			obj.width = "520";
		}
		
		if (height != null) {
			obj.height = height;
		} else {
			obj.height = "300";
		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);

		if (onActivate != null) {
			obj.listeners.put("activate", new JsFunction(onActivate));
		}

		if (onBeforePush != null) {
			obj.listeners.put("beforepush", new JsFunction(onBeforePush));
		}

		if (onBeforeSync != null) {
			obj.listeners.put("beforesync", new JsFunction(onBeforeSync));
		}

		if (onEditModeChange != null) {
			obj.listeners.put("editmodechange", new JsFunction(onEditModeChange));
		}

		if (onInitialize != null) {
			obj.listeners.put("initialize", new JsFunction(onInitialize));
		}

		if (onPush != null) {
			obj.listeners.put("push", new JsFunction(onPush));
		}

		if (onSync != null) {
			obj.listeners.put("sync", new JsFunction(onSync));
		}
	}

	/**
	 * The default text for the create link prompt
	 */
	public void setCreateLinkText(String createLinkText) {
		this.createLinkText = createLinkText;
	}

	/**
	 * The default value for the create link prompt (defaults to http://)
	 */
	public void setDefaultLinkValue(String defaultLinkValue) {
		this.defaultLinkValue = defaultLinkValue;
	}

	/**
	 * Enable the left, center, right alignment buttons (defaults to true)
	 */
	public void setEnableAlignments(String enableAlignments) {
		this.enableAlignments = enableAlignments;
	}

	/**
	 * Enable the fore/highlight color buttons (defaults to true)
	 */
	public void setEnableColors(String enableColors) {
		this.enableColors = enableColors;
	}

	/**
	 * Enable font selection. Not available in Safari. (defaults to true)
	 */
	public void setEnableFont(String enableFont) {
		this.enableFont = enableFont;
	}

	/**
	 * Enable the increase/decrease font size buttons (defaults to true)
	 */
	public void setEnableFontSize(String enableFontSize) {
		this.enableFontSize = enableFontSize;
	}

	/**
	 * Enable the bold, italic and underline buttons (defaults to true)
	 */
	public void setEnableFormat(String enableFormat) {
		this.enableFormat = enableFormat;
	}

	/**
	 * Enable the create link button. Not available in Safari. (defaults to true)
	 */
	public void setEnableLinks(String enableLinks) {
		this.enableLinks = enableLinks;
	}

	/**
	 * Enable the bullet and numbered list buttons. Not available in Safari. (defaults to true)
	 */
	public void setEnableLists(String enableLists) {
		this.enableLists = enableLists;
	}

	/**
	 * Enable the switch to source edit button. Not available in Safari. (defaults to true)
	 */
	public void setEnableSourceEdit(String enableSourceEdit) {
		this.enableSourceEdit = enableSourceEdit;
	}

	/**
	 * An array of available font families
	 */
	public void setFontFamilies(String fontFamilies) {
		this.fontFamilies = fontFamilies;
	}

	/**
	 * <p>Fires when the editor is first receives the focus. Any insertion must wait until after this event. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : HtmlEditor</li>
     * </ul>
	 * @param onActivate
	 */
	public void setOnActivate(String onActivate) {
		this.onActivate = onActivate;
	}

	/**
	 * <p>Fires before the iframe editor is updated with content from the textarea. Return false to cancel the push. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : HtmlEditor</li>
	 * <li><strong>html</strong> : String</li>
     * </ul>
	 * @param onBeforePush
	 */
	public void setOnBeforePush(String onBeforePush) {
		this.onBeforePush = onBeforePush;
	}

	/**
	 * <p>Fires before the textarea is updated with content from the editor iframe. Return false to cancel the sync. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : HtmlEditor</li>
	 * <li><strong>html</strong> : String</li>
     * </ul>
	 * @param onBeforeSync
	 */
	public void setOnBeforeSync(String onBeforeSync) {
		this.onBeforeSync = onBeforeSync;
	}

	/**
	 * <p>Fires when the editor switches edit modes </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : HtmlEditor</li>
	 * <li><strong>sourceEdit</strong> :(Boolean) True if source edit, false if standard editing.</li>
     * </ul>
	 * @param onEditModeChange
	 */
	public void setOnEditModeChange(String onEditModeChange) {
		this.onEditModeChange = onEditModeChange;
	}

	/**
	 * <p>Fires when the editor is fully initialized (including the iframe) </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : HtmlEditor</li>
     * </ul>
	 * @param onInitialize
	 */
	public void setOnInitialize(String onInitialize) {
		this.onInitialize = onInitialize;
	}

	/**
	 * <p>Fires when the iframe editor is updated with content from the textarea. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : HtmlEditor</li>
	 * <li><strong>html</strong> : String</li>
     * </ul>
	 * @param onPush
	 */
	public void setOnPush(String onPush) {
		this.onPush = onPush;
	}

	/**
	 * <p>Fires when the textarea is updated with content from the editor iframe. </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : HtmlEditor</li>
	 * <li><strong>html</strong> : String</li>
     * </ul>
	 * @param onSync
	 */
	public void setOnSync(String onSync) {
		this.onSync = onSync;
	}

	/**
	 * Width of the object
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * Height of the object
	 */
	public void setHeight(String height) {
		this.height = height;
	}
}
