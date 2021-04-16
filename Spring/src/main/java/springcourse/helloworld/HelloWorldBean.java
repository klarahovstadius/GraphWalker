package springcourse.helloworld;

public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String message) {
        this.message = message; //this sets what will be displayed in the browser (message)
    }

    //We need to use setters and getters even though they are not called

    public void setMessage() {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    /**
     * toString() returns the string representation of an object (not used)
     */
    @Override
    public String toString(){
        return String.format("HelloWorldBean [message?%s]",message);
    }

}
