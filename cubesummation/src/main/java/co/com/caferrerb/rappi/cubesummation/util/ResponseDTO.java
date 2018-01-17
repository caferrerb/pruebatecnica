package co.com.caferrerb.rappi.cubesummation.util;

public class ResponseDTO {

    private String mensaje;
    private String codigo;
    private Object data;

    public ResponseDTO(String mensaje, String codigo, Object data) {
        this.mensaje = mensaje;
        this.codigo = codigo;
        this.data = data;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
