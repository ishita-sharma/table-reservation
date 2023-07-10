CREATE TABLE TABLE_RESERVATION (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    cuisine VARCHAR(40) NOT NULL,
    category ENUM('COFFEE','BAR','TAKE_AWAY','RESTAURANT','FAST_FOOD') NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    PRIMARY KEY (id)
);