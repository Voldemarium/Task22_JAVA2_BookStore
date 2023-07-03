CREATE SCHEMA IF NOT EXISTS bookStore;

	create table book_store.book
(
    id                  serial primary key unique not null,
    title               text not null,
    author_id           integer  not null,
    pages               int  not null,
    publishing_house    text not null,
    year_or_publication int  not null,
    publication_number  int,
    price               int  not null
);

	create table book_store.warehouse
(
    id             serial primary key unique not null,
    book_id        integer  not null,
    balance_count  int  not null
);

create table book_store.author
(
    id             serial primary key unique not null,
    surname        text not null,
    "name"         text not null,
    middle_name    text,
	year_of_birtch int
);

create table book_store.customer
(
    id             serial primary key unique not null,
    surname        text not null,
    "name"         text not null,
    middle_name    text,
	date_of_birtch date
);

	create table book_store.ordering
(
    id              serial primary key unique not null,
    customer_id     integer  not null,
    purchase_amount int  not null
);

	create table book_store.ordering_details
(
    id              serial primary key unique not null,
    ordering_id     integer  not null,
    book_id         integer  not null,
    price           int  not null,
    quantity        int  not null
);