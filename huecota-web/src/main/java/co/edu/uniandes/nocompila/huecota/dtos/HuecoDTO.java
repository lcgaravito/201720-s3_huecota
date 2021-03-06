/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.nocompila.huecota.dtos;

import co.edu.uniandes.nocompila.huecota.entities.HuecoEntity;

/**
 * HuecoDTO Objeto de transferencia de datos de Huecoes. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 *
 * @author ch.patino
 */
public class HuecoDTO {

    private Long id;
    private String descripcion;
    private String cerrado;

    /**
     * Constructor por defecto
     */
    public HuecoDTO() {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param Hueco: Es la entidad que se va a convertir a DTO
     */
    public HuecoDTO(HuecoEntity Hueco) {
        if (Hueco != null) {
            this.id = Hueco.getId();
            this.descripcion = Hueco.getDescripcion();
            this.cerrado = Hueco.getCerrado();
        }
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public HuecoEntity toEntity() {
        HuecoEntity entity = new HuecoEntity();
        entity.setId(this.id);
        entity.setDescripcion(this.descripcion);
        entity.setCerrado(this.cerrado);
        return entity;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id id a cambiar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion descripcion a cambiar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return cerrado
     */
    public String getCerrado() {
        return cerrado;
    }

    /**
     * @param cerrado cerrado a cambiar
     */
    public void setCerrado(String cerrado) {
        this.cerrado = cerrado;
    }
}
