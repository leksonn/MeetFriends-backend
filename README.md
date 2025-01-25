# MeetFriends-Backend

This project is built with Node.js and PostgreSQL.

## Development Server

Run npm start to start the development server. 

## Features

User Management: Handle user registration, authentication, and profile updates.

Friends List: View and manage friends.

Add Friends: Add new friends to your list.

Schedule: Create and manage meetups with friends.

Meetup Confirmation: Accept a meetup request.

Meetup Request: Send a meetup request.

Streak: Keep track of streaks for successful meetups between friends.

## Technologies Used

Framework: Express.js

Database: PostgreSQL

ORM: Sequelize

Authentication: JSON Web Tokens (JWT)

## Getting Started

### Prerequisites

Node.js (v16.x or later)

PostgreSQL (v12.x or later)

### Installation

Clone the repository:

git clone https://github.com/leksonn/meetfriends-backend.git
cd meetfriends-backend

Install dependencies:

npm install

Configure the environment file:

Create a .env file in the root directory.

Add the following variables:

PORT=5000
DB_HOST=localhost
DB_PORT=5432
DB_USER=your_db_user
DB_PASSWORD=your_db_password
DB_NAME=meetfriends_db
JWT_SECRET=your_secret_key

Set up the database:

npx sequelize db:create
npx sequelize db:migrate

Start the server:

npm start

## Project Structure

src/models: Sequelize models for database tables.

src/routes: API route handlers.

src/controllers: Logic for processing requests and responses.

src/middleware: Middleware for authentication and validation.

## Usage

Register or log in to create your profile.

Add friends by providing their usernames.

Schedule meetups and track streaks of successful meetups.

Manage friends list and scheduled meetups easily.

## Build

To create a production build:

npm run build

The build artifacts will be stored in the dist/ directory.

## Testing

Run tests:

npm test

## Contributing

Fork the repository.

Create a feature branch: git checkout -b feature-name

Commit your changes: git commit -m 'Add some feature'

Push to the branch: git push origin feature-name

Create a pull request.

## Further Help

To get more help on Sequelize, Express, or other tools used in this project, refer to their official documentation.

