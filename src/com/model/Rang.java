package com.model;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rang")
public class Rang {
	private HashMap<String, Place> places;
}
