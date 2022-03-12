package by.training.candies.parameters;

public enum Form {
    RECTANGULAR("Rectangular"),
    ROUND("Round"),
    SQUARE("Square"),
    OVAL("Oval"),
    RELIEF("Relief"),
    FREE("Free");
    String form;

    Form(String form) {
        this.form = form;
    }

    public static Form getForm(String typeform) {
        for (Form forms : Form.values()) {
            if (forms.form.equals(typeform)) {
                return forms;
            }
        }
        return null;
    }
}
