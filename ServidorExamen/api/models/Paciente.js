/**
 * Paciente.js
 *
 * @description :: A model definition.  Represents a database table/collection/etc.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre: {
      type: 'string'
    },
    apellido: {
      type: 'string'
    },
    fechaNacimiento: {
      type: 'string'
    },
    numeroHijos: {
      type: 'number'
    },
    afiliado: {
      type: 'number'
    },
    medicina: {
      collection: 'Medicina',
      via: 'pacienteId'
    },
    foto: {
      collection: 'Fotos',
      via: 'pacienteId'
    },

  },

};

