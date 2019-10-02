package command;


public class CommandData {

    private String _className;
    private String _methodName;
    private String[] _paramTypes;
    private Object[] _paramValues;

    public CommandData(String className, String methodName, String[] paramTypes, Object[] paramValues) {
        _className = className;
        _methodName = methodName;
        _paramTypes = paramTypes;
        _paramValues = paramValues;
    }

    public String get_className() {
        return _className;
    }

    public void set_className(String _className) {
        this._className = _className;
    }

    public String get_methodName() {
        return _methodName;
    }

    public void set_methodName(String _methodName) {
        this._methodName = _methodName;
    }

    public String[] get_paramTypes() {
        return _paramTypes;
    }

    public void set_paramTypes(String[] _paramTypes) {
        this._paramTypes = _paramTypes;
    }

    public Object[] get_paramValues() {
        return _paramValues;
    }

    public void set_paramValues(Object[] _paramValues) {
        this._paramValues = _paramValues;
    }
}
