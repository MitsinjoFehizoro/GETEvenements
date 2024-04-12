module.exports = (sequelize, DataTypes) => {
    return sequelize.define("ConcoursProjet", {
        id :{
            type : DataTypes.INTEGER,
            primaryKey : true,
            autoIncrement : true
        },
        jurry :{
            type : DataTypes.STRING,
            allowNull : false,
            validate : {
                notEmpty : "Le jurry ne peut pas etre vide.",
                notNull : "Le jurry est une propriete requise."
            }
        }
    })
};
