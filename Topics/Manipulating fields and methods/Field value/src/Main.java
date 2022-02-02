
class FieldGetter {

    public Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        try {
            return object.getClass().getField(fieldName).get(object);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

}