const validCibles = ["MP1", "M1", "TCO", "LP1", "L1"];

module.exports = (sequelize, DataTypes) => {
  return sequelize.define("Conference", {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    intervenant: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        notEmpty: "L'intervenant ne peut pas etre vide.",
        notNull: "L'intervenant est une propriete requise.",
      },
    },
    cible: {
      type: DataTypes.STRING,
      get() {
        return this.getDataValue("cible").split(",");
      },
      set(cible) {
        this.setDataValue("cible", cible.join());
      },
      validate: {
        isCibleValid(value) {
          if (value) {
            value.split(",").forEach((val) => {
              if (!validCibles.includes(val)) {
                throw new Error(
                  `Les valeurs du cible doit appartenir a la liste suivante ${validCibles}`
                );
              }
            });
          } else {
            throw new Error("Le cible doit avoir une valeur au minimum.");
          }
        },
      },
    },
  });
};
