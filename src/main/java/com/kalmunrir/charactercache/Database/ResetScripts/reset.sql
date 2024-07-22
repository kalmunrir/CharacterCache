/*******************************************
  Drop Tables
********************************************/
/* Primary Tables */
drop table if exists Characters;
drop table if exists AbilityBonuses;
drop table if exists Skills;
drop table if exists SuperRaces;
drop table if exists Traits;
drop table if exists Proficiencies;
drop table if exists MagicSchools;
drop table if exists Mediums;
drop table if exists Jobs;
drop table if exists Languages;
drop table if exists Features;
drop table if exists Spells;
/* Secondary Tables */
drop table if exists CharacterAbilityScores;
drop table if exists CharacterSurvivability;
drop table if exists CharacterWealth;
drop table if exists CharacterSpellSlots;
drop table if exists Items;
drop table if exists Armor;
drop table if exists Weapons;
drop table if exists Subjobs;
drop table if exists MultijobRequirements;
drop table if exists TypicalSpeakers;
drop table if exists Races;
/* Join Tables */
drop table if exists CharacterSkills;
drop table if exists CharacterLanguages;
drop table if exists CharacterProficiencies;
drop table if exists CharacterJobs;
drop table if exists CharacterSubjobs;
drop table if exists SuperRaceAbilityBonuses;
drop table if exists SuperRaceTraits;
drop table if exists RaceAbilityBonuses;
drop table if exists RacialTraits;
drop table if exists RaceProficiencies;
drop table if exists RaceLanguages;
drop table if exists JobProficiencies;
drop table if exists JobLanguages;
drop table if exists MultijobProficiencies;
drop table if exists SpellJobs;
drop table if exists SpellSchools;
drop table if exists SpellMediums;

/*******************************************
  Primary Tables
********************************************/
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

create table if not exists AbilityBonuses (
    id integer primary key autoincrement not null unique,
    ability text not null,
    bonus integer not null
);
create table if not exists Skills (
    id integer primary key autoincrement not null unique,
    name text not null,
    description text not null,
    ability text not null
);

create table if not exists SuperRaces (
    id integer primary key autoincrement not null unique,
    name text not null unique
);

create table if not exists Traits (
    id integer primary key autoincrement not null unique,
    name text not null unique,
    description text
);
create table if not exists Proficiencies (
    id integer primary key autoincrement not null unique,
    name text not null unique ,
    type text
);
create table if not exists MagicSchools (
    id integer primary key autoincrement not null unique,
    name text not null unique
);
create table if not exists Mediums (
    id integer primary key autoincrement not null unique,
    shortName text not null,
    name text not null
);
create table if not exists Jobs (
    id integer primary key autoincrement not null unique,
    name text not null,
    hitDie integer not null,
    spellCastingAbility text
);
create table if not exists Languages (
    id integer primary key autoincrement not null unique,
    name text not null,
    type text not null
);
create table if not exists Features (
    id integer primary key autoincrement not null unique,
    name text not null,
    reqLevel integer not null,
    description text
);
create table if not exists Spells (
    id integer primary key autoincrement not null unique,
    name text not null,
    level integer not null,
    ritual integer not null,
    concentration integer not null,
    castingTime text not null,
    distance text not null,
    duration text not null,
    materials text,
    description text not null
);

/*******************************************
  Secondary Tables
********************************************/
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

create table if not exists Subjobs (
    id integer primary key autoincrement not null unique,
    name text not null unique,
    description text,
    jobId integer not null,
    foreign key (jobId) references Jobs (id) on delete cascade
);
create table if not exists MultijobRequirements (
    id integer primary key autoincrement not null unique,
    ability text not null ,
    required integer not null ,
    jobId integer not null,
    foreign key (jobId) references Jobs (id) on delete cascade
);
create table if not exists TypicalSpeakers (
    id integer primary key autoincrement not null unique,
    name text not null unique,
    languageId integer not null,
    foreign key (languageId) references Languages (id) on delete cascade
);

create table if not exists Races (
    id integer primary key autoincrement not null unique,
    name text not null,
    size text not null,
    walkSpeed integer not null,
    flySpeed integer,
    swimSpeed integer,
    superRaceId integer not null,
    foreign key (superRaceId) references SuperRaces (id) on delete cascade
);
/*******************************************
  Join Tables
********************************************/
create table if not exists CharacterSkills (
    id integer primary key autoincrement not null unique,
    modifier integer not null,
    proficiency integer not null,
    expertise integer not null,
    jackOfAllTrades integer not null,
    characterId integer not null,
    skillId integer not null,
    foreign key (characterId) references Characters (id) on delete cascade,
    foreign key (skillId) references Skills (id) on delete cascade
);
create table if not exists CharacterLanguages (
    id integer primary key autoincrement not null unique,
    characterId integer not null,
    languageId integer not null,
    foreign key (characterId) references Characters (id) on delete cascade,
    foreign key (languageId) references Languages (id) on delete cascade
);
create table if not exists CharacterProficiencies (
    id integer primary key autoincrement not null unique,
    characterId integer not null,
    proficiencyId integer not null,
    foreign key (characterId) references Characters (id) on delete cascade,
    foreign key (proficiencyId) references Proficiencies (id) on delete cascade
);
create table if not exists CharacterSubjobs (
    id integer primary key autoincrement not null unique,
    characterId integer not null,
    subJobId integer not null,
    foreign key (characterId) references Characters (id) on delete cascade,
    foreign key (subJobId) references Subjobs (id) on delete cascade
);
create table if not exists SuperRaceAbilityBonuses (
    id integer primary key autoincrement not null unique,
    superRaceId integer not null,
    abilityBonusId integer not null,
    foreign key (superRaceId) references SuperRaces (id) on delete cascade,
    foreign key (abilityBonusId) references AbilityBonuses (id) on delete cascade
);
create table if not exists SuperRaceTraits (
    id integer primary key autoincrement not null unique,
    superRaceId integer not null,
    traitId integer not null,
    foreign key (superRaceId) references SuperRaces (id) on delete cascade,
    foreign key (traitId) references Traits (id) on delete cascade
);
create table if not exists RaceAbilityBonuses (
    id integer primary key autoincrement not null unique,
    raceId integer not null,
    abilityBonusId integer not null,
    foreign key (raceId) references Races (id) on delete cascade,
    foreign key (abilityBonusId) references AbilityBonuses (id) on delete cascade
);
create table if not exists RacialTraits (
    id integer primary key autoincrement not null unique,
    raceId integer not null,
    traitId integer not null,
    foreign key (raceId) references Races (id) on delete cascade,
    foreign key (traitId) references Traits (id) on delete cascade
);
create table if not exists RaceProficiencies (
    id integer primary key autoincrement not null unique,
    raceId integer not null,
    proficiencyId integer not null,
    foreign key (raceId) references Races (id) on delete cascade,
    foreign key (proficiencyId) references Proficiencies (id) on delete cascade
);
create table if not exists RaceLanguages (
    id integer primary key autoincrement not null unique,
    raceId integer not null,
    languageId integer not null,
    foreign key (raceId) references Races (id) on delete cascade,
    foreign key (languageId) references Languages (id) on delete cascade
);
create table if not exists JobProficiencies (
    id integer primary key autoincrement not null unique,
    jobId integer not null,
    proficiencyId integer not null,
    foreign key (jobId) references Jobs (id) on delete cascade,
    foreign key (proficiencyId) references Proficiencies (id) on delete cascade
);
create table if not exists CharacterJobs (
    id integer primary key autoincrement not null unique,
    first integer not null,
    level integer not null,
    isXP integer not null,
    currentXP integer,
    xpToLevelUp integer,
    currentNumHitDie integer not null,
    characterId integer not null,
    jobId integer not null,
    foreign key (characterId) references Characters (id) on delete cascade,
    foreign key (jobId) references Jobs (id) on delete cascade
);
create table if not exists JobLanguages (
    id integer primary key autoincrement not null unique,
    jobId integer not null,
    languageId integer not null,
    foreign key (jobId) references Jobs (id) on delete cascade,
    foreign key (languageId) references Languages (id) on delete cascade
);
create table if not exists MultijobProficiencies (
    id integer primary key autoincrement not null unique,
    multijobId integer not null,
    proficiencyId integer not null,
    foreign key (multijobId) references MultijobRequirements (id) on delete cascade,
    foreign key (proficiencyId) references Proficiencies (id) on delete cascade
);
create table  if not exists SpellJobs (
    id integer primary key autoincrement not null unique,
    spellId integer not null,
    jobId integer not null,
    foreign key (spellId) references Spells (id) on delete cascade,
    foreign key (jobId) references Jobs (id) on delete cascade
);
create table if not exists SpellSchools (
    id integer primary key autoincrement not null unique,
    spellId integer not null,
    magicSchoolId integer not null,
    foreign key (spellId) references Spells (id) on delete cascade,
    foreign key (magicSchoolId) references MagicSchools (id) on delete cascade
);
create table if not exists SpellMediums (
    id integer primary key autoincrement not null unique,
    spellId integer not null,
    mediumId integer not null,
    foreign key (spellId) references Spells (id) on delete cascade,
    foreign key (mediumId) references Mediums (id) on delete cascade
);
/*******************************************
  Fill In Tables
********************************************/

insert into MagicSchools (name)
values ('Abjuration'),
       ('Conjuration'),
       ('Divination'),
       ('Enchantment'),
       ('Evocation'),
       ('Illusion'),
       ('Necromancy'),
       ('Transmutation');

insert into Mediums (shortName, name)
values ('V', 'Verbal'),
       ('S', 'Semantic'),
       ('M', 'Material');

insert into AbilityBonuses (ability, bonus)
values ('Strength', 1),
       ('Strength', 2),
       ('Dexterity', 1),
       ('Dexterity', 2),
       ('Constitution', 1),
       ('Constitution', 2),
       ('Intelligence', 1),
       ('Intelligence', 2),
       ('Wisdom', 1),
       ('Wisdom', 2),
       ('Charisma', 1),
       ('Charisma', 2);
