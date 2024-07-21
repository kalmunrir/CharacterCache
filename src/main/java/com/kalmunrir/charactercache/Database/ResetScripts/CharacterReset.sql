drop table if exists Characters;
drop table if exists Skills;
drop table if exists CharacterBaseRolls;
drop table if exists CharacterAbilityScores;
drop table if exists CharacterSurvivability;
drop table if exists CharacterWealth;
drop table if exists CharacterSpellSlots;
drop table if exists Items;
drop table if exists Armor;
drop table if exists Weapons;
drop table if exists CharacterSkills;


create table if not exists Characters (
    id integer primary key autoincrement not null unique,
    name text not null,
    alignment text,
    backstory text,
    background text,
    personalityTraits text,
    ideals text,
    bonds text,
    flaws text,
    physicalDescription text,
    politics text,
    proficiencyBonus integer not null,
    playerName text not null,
    notes text
);

create table if not exists Skills (
    id integer primary key autoincrement not null unique,
    name text not null,
    description text not null,
    ability text not null
);

create table if not exists CharacterBaseRolls (
    id integer primary key autoincrement not null unique,
    strengthRoll integer not null,
    dexterityRoll integer not null,
    constitutionRoll integer not null,
    intelligenceRoll integer not null,
    wisdomRoll integer not null,
    charismaRoll integer not null,
    characterId integer not null,
    foreign key (characterId) references Characters (id) on delete cascade
);

create table if not exists CharacterAbilityScores (
    id integer primary key autoincrement not null unique,
    strength integer not null,
    dexterity integer not null,
    constitution integer not null,
    intelligence integer not null,
    wisdom integer not null,
    charisma integer not null,
    characterId integer not null,
    foreign key (characterId) references Characters (id) on delete cascade
);

create table if not exists CharacterSurvivability (
    id integer primary key autoincrement not null unique,
    armorClass integer not null,
    initiative integer not null,
    speed integer not null,
    totalHP integer not null,
    currentHP integer not null,
    tempHP integer not null,
    passivePerception integer not null,
    deathSavesSuccess integer not null,
    deathSavesFail integer not null,
    inspiration integer not null,
    characterId integer not null,
    foreign key (characterId) references Characters (id) on delete cascade
);

create table if not exists CharacterWealth (
    id integer primary key autoincrement not null unique,
    copperPieces integer not null,
    silverPieces integer not null,
    electrumPieces integer not null,
    goldPieces integer not null,
    platinumPieces integer not null,
    totalWealth REAL not null,
    characterId integer not null,
    foreign key (characterId) references Characters (id) on delete cascade
);

create table if not exists CharacterSpellSlots (
    id integer primary key autoincrement not null unique,
    firstLevelSS integer not null,
    secondLevelSS integer not null,
    thirdLevelSS integer not null,
    fourthLevelSS integer not null,
    fifthLevelSS integer not null,
    sixthLevelSS integer not null,
    seventhLevelSS integer not null,
    eighthLevelSS integer not null,
    ninthLevelSS integer not null,
    characterId integer not null,
    foreign key (characterId) references Characters (id) on delete cascade
);

create table if not exists Items (
    id integer primary key autoincrement not null unique,
    name text not null unique,
    pricePerUnit real not null,
    weightPerUnit integer not null,
    quantity integer not null,
    category text not null,
    description text,
    characterId integer not null,
    foreign key (characterId) references Characters (id) on delete cascade
);

create table if not exists Armor (
    id integer primary key autoincrement not null unique,
    armorType text not null,
    armorClass integer not null,
    withDex integer not null,
    strengthReq integer not null,
    stealthDis integer not null,
    itemId integer not null,
    foreign key (itemId) references Items (id) on delete cascade
);

create table if not exists Weapons (
    id integer primary key autoincrement not null unique,
    distance text not null,
    damageDie integer not null,
    numDie integer not null,
    damageType text not null,
    itemId integer not null,
    foreign key (itemId) references Items (id) on delete cascade
);

/* Jack of all trades in features table
 * Proficiency in proficiencies table
*/
create table if not exists CharacterSkills (
    id integer primary key autoincrement not null unique,
    modifier integer not null,
    expertise integer not null,
    characterId integer not null,
    skillId integer not null,
    foreign key (characterId) references Characters (id) on delete cascade,
    foreign key (skillId) references Skills (id) on delete cascade
);