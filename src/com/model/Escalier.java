package com.model;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Escalier")
public class Escalier {
	private HashMap<String, Rang> rangs;
}
