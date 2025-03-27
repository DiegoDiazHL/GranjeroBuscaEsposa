package Terrenos;

public class MateriaPrima {
        private String tipo;
        private Integer recurso;
        private boolean alimentado;
        private Integer precio;

        public MateriaPrima(String tipo, Integer recurso, boolean alimentado, Integer precio) {
                this.tipo = tipo;
                this.recurso = recurso;
                this.alimentado = alimentado;
                this.precio = precio;
        }

        public String getTipo() {
                return tipo;
        }

        public void setTipo(String tipo) {
                this.tipo = tipo;
        }

        public Integer getRecurso() {
                return recurso;
        }

        public void setRecurso(Integer recurso) {
                this.recurso = recurso;
        }

        public boolean isAlimentado() {
                return alimentado;
        }

        public void setAlimentado(boolean alimentado) {
                this.alimentado = alimentado;
        }

        public Integer getPrecio() {
                return precio;
        }

        public void setPrecio(Integer precio) {
                this.precio = precio;
        }

        @Override
        public String toString() {
                return "MateriaPrima{" +
                        "tipo='" + tipo + '\'' +
                        ", recurso=" + recurso +
                        ", alimentado=" + alimentado +
                        ", precio=" + precio +
                        '}';
        }
}
