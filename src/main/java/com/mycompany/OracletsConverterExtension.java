package com.mycompany;

import org.mule.runtime.extension.api.annotation.ExpressionFunctions;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;

@Xml(prefix = "Converter")
@Extension(name= "Converter Functions")
@ExpressionFunctions(OracletsConverterFunctions.class)
public class OracletsConverterExtension {

}