package com.saifiahmada.inventory.util;

public class TrioNvl {
	
	public static Number nvl(Object sourceValue, Number defaultValue)
	  {
	    return nvl((Number)sourceValue, defaultValue);
	  }

	  public static Number nvl(Number sourceValue, Number defaultValue)
	  {
	    if (sourceValue == null) {
	      return defaultValue;
	    }
	    return sourceValue;
	  }

	  public static String nvl(Object sourceValue, String defaultValue)
	  {
	    String strTemp;
	    if (sourceValue == null)
	      strTemp = defaultValue;
	    else {
	      strTemp = sourceValue.toString();
	    }

	    return strTemp;
	  }

	  public static String nvl(Object sourceValue)
	  {
	    return nvl(sourceValue, "");
	  }

	  public static String nvl(Object[] sourceValue, String defaultValue, int index)
	  {
	    String strTemp;
	    if (sourceValue == null)
	      strTemp = defaultValue;
	    else {
	      strTemp = nvl(sourceValue[index], defaultValue);
	    }

	    return strTemp;
	  }

	  public static String nvl(Object[] sourceValue, int index)
	  {
	    return nvl(sourceValue, "", index);
	  }

}
