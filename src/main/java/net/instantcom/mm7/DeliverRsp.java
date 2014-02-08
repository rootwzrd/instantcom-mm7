/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2014 InstantCom Ltd. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://raw.github.com/vnesek/instantcom-mm7/master/LICENSE.txt
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at appropriate location.
 */

package net.instantcom.mm7;

import org.jdom2.Element;

public class DeliverRsp extends MM7Response {

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String messageId) {
		this.serviceCode = messageId;
	}

	@Override
	public void load(Element element) {
		super.load(element);

		Element body = element.getChild("Body", JDOMSupport.ENVELOPE);
		Element rsp = body.getChild("DeliverRsp", namespace);
		setServiceCode(rsp.getChildTextTrim("ServiceCode", namespace));
	}
	
	@Override
	public Element save(Element parent) {
		Element e = super.save(parent);
		if (serviceCode != null) {
			e.addContent(new Element("ServiceCode", e.getNamespace()).setText(serviceCode));
		}
		return e;
	}

	private String serviceCode;
}
