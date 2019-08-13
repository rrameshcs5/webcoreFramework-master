import org.apache.commons.lang3.StringUtils;

public abstract class ElementSelector {
    String locatorValue;
    public abstract String xpathCreator(String tagName, String className);
    public String contains(String attribute, String value){
        return "[contains(@"+attribute+","+"'"+ value+"')]";
    }
    public static class ById extends ElementSelector{

        public ById(String id){
            this.locatorValue =id;
        }
        public String xpathCreator(String tagName, String className) {
            StringBuilder xpathString = new StringBuilder();
             xpathString.append("//")
                    .append(StringUtils.isBlank(tagName)?"*":tagName.trim())
                    .append(StringUtils.isBlank(className) ? "" : contains("class",className))
                    .append("[@id='")
                    .append(locatorValue)
                    .append("']");

            return xpathString.toString();
        }
    }
}
