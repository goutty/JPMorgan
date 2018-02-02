package pt.messages;

public class Messages {

	private Messages() {
        // restrict instantiation of Messages
	}
	
	public static final String MESSAGES_TYPE_1 = "%1$s at %2$s"; //apple at 10p
	public static final String MESSAGES_TYPE_2 = "%1$s %2$s"; //20 sales of apples at 10p each
	public static final String MESSAGES_TYPE_3 = "%1$s"; //Add 20p apples
	
	//defaults
	public static final String DEFAULT_CURRENCY = "p";
}
