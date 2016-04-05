package br.com.app.converter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@ConversationScoped
@FacesConverter("entityConverter")
public class ObjectConverter implements javax.faces.convert.Converter, Serializable {

	private static final long serialVersionUID = -406332789399557968L;
	final private Map<String, Object> converterMap = new HashMap<String, Object>();
	final private Map<Object, String> reverseConverterMap = new HashMap<Object, String>();

	@Inject
	private transient Conversation conversation;

	private int incrementor = 1;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (this.conversation.isTransient()) {

		}

		return this.converterMap.get(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (this.conversation.isTransient()) {

		}

		if (this.reverseConverterMap.containsKey(value)) {
			return this.reverseConverterMap.get(value);
		} else {
			final String incrementorStringValue = String.valueOf(this.incrementor++);
			this.converterMap.put(incrementorStringValue, value);
			this.reverseConverterMap.put(value, incrementorStringValue);
			return incrementorStringValue;
		}
	}
}