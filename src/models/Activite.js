module.exports = (sequelize, DataTypes) => {
  return sequelize.define("Activite", {
    id: {
      type: DataTypes.INTEGER,
      primaryKey: true,
      autoIncrement: true,
    },
    title: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        notEmpty: { msg: "Le titre de l'activite ne peut pas etre vide." },
        notNull: { msg: "Le titre l'activite est une propriete requise." },
      },
    },
    description: {
      type: DataTypes.STRING,
      allowNull: true,
    },
  });
};
