# LLD Practice Questions

This document contains low-level design practice prompts with scoped requirements. For each problem, try to identify:

- Core entities and responsibilities
- Relationships and interfaces
- Design patterns that fit naturally
- Edge cases and extensibility points
- Tradeoffs in API and class design

---

## 1. Parking Lot System

### Problem
Design a parking lot system that supports different vehicle types and multiple parking floors.

### Functional Specs
- Support vehicle types such as bike, car, and truck.
- Support multiple entry and exit gates.
- Allocate the nearest available slot for a given vehicle type.
- Generate a parking ticket at entry.
- Calculate parking fees at exit based on vehicle type and duration.
- Mark slots as occupied or available.

### Non-Functional / Design Expectations
- The design should be extensible for new vehicle types.
- Pricing strategies should be easy to change.
- Gate logic should not be tightly coupled with payment logic.

### Follow-up Constraints
- Add support for electric vehicle charging spots.
- Add support for reservations.
- Add admin APIs for occupancy reports.

---

## 2. Library Management System

### Problem
Design a library management system for issuing and returning books.

### Functional Specs
- Support searching books by title, author, subject, and ISBN.
- Allow members to borrow and return books.
- Track multiple physical copies of the same book.
- Enforce borrowing limits per member.
- Calculate fines for overdue returns.
- Support librarians managing inventory.

### Non-Functional / Design Expectations
- Separate catalog data from physical book copies.
- Fine calculation should be replaceable.
- Member and librarian responsibilities should be clearly separated.

### Follow-up Constraints
- Add waitlisting for unavailable books.
- Add notifications for due dates and reservations.
- Add support for reference-only books.

---

## 3. Movie Ticket Booking System

### Problem
Design a movie ticket booking system like BookMyShow for a single city.

### Functional Specs
- List theaters, screens, movies, and shows.
- Allow users to view seat layouts for a show.
- Let users select seats and book tickets.
- Prevent double-booking of the same seat.
- Support booking cancellation.
- Support different seat categories and pricing.

### Non-Functional / Design Expectations
- The design should model seat locking clearly.
- Pricing should support future discount strategies.
- Booking flow should be decoupled from payment integration.

### Follow-up Constraints
- Add support for coupons and offers.
- Add multiple cities.
- Add concurrent booking handling explicitly.

---

## 4. Elevator System

### Problem
Design an elevator control system for a building with multiple elevators.

### Functional Specs
- Support external requests from floors for up/down directions.
- Support internal destination requests from inside elevators.
- Assign the best elevator to a request.
- Track current floor, direction, and state of each elevator.
- Support idle, moving, and maintenance modes.

### Non-Functional / Design Expectations
- Scheduling logic should be pluggable.
- Elevator state transitions should be clear and testable.
- The design should scale from a small building to a large one.

### Follow-up Constraints
- Add VIP priority requests.
- Add fire/emergency mode.
- Add load/capacity-based dispatch rules.

---

## 5. Cache System

### Problem
Design an in-memory cache with pluggable eviction strategies.

### Functional Specs
- Support `put(key, value)`, `get(key)`, and `remove(key)`.
- Enforce a fixed capacity.
- Evict entries when capacity is exceeded.
- Support at least LRU and LFU eviction policies.
- Return cache miss when a key does not exist.

### Non-Functional / Design Expectations
- Eviction policy should be interchangeable.
- Core cache APIs should not change when policies change.
- Internal data structures should support efficient operations.

### Follow-up Constraints
- Add TTL expiration.
- Add thread-safety requirements.
- Add metrics such as hit rate and eviction count.

---

## 6. Splitwise System

### Problem
Design a simplified expense-sharing application like Splitwise.

### Functional Specs
- Support creating users and groups.
- Add expenses among users.
- Support equal, exact, and percentage splits.
- Track balances between users.
- Show total amount a user owes or gets back.

### Non-Functional / Design Expectations
- Split calculation should use strategy-based design.
- Expense representation should be easy to extend.
- Balance updates should be consistent and easy to reason about.

### Follow-up Constraints
- Add recurring expenses.
- Add expense settlement history.
- Add support for multi-currency balances.

---

## 7. Snake and Ladder

### Problem
Design the backend logic for a Snake and Ladder game.

### Functional Specs
- Support multiple players.
- Roll dice and move players turn by turn.
- Handle snakes and ladders on the board.
- Detect winning condition.
- Allow configurable board size and dice behavior.

### Non-Functional / Design Expectations
- Game flow should be cleanly modeled.
- Board setup should be configurable.
- Dice logic should be replaceable for testing.

### Follow-up Constraints
- Add multiple dice.
- Add custom rules such as exact roll needed to win.
- Add save/resume support.

---

## 8. ATM System

### Problem
Design an ATM system for basic banking operations.

### Functional Specs
- Authenticate a user using card and PIN.
- Support cash withdrawal, balance inquiry, and mini statement.
- Validate account balance before withdrawal.
- Dispense cash using available denominations.
- Print or generate transaction receipts.

### Non-Functional / Design Expectations
- Authentication, transaction processing, and cash dispensing should be separate concerns.
- Cash dispensing strategy should be extensible.
- Device components should be modeled explicitly where useful.

### Follow-up Constraints
- Add deposit support.
- Add multiple account types.
- Add backend bank service abstraction.

---

## 9. Vending Machine

### Problem
Design a vending machine that dispenses products after payment.

### Functional Specs
- Display available products and prices.
- Allow product selection.
- Accept coins/cash input.
- Dispense item if enough money is inserted.
- Return change when applicable.
- Handle out-of-stock items.

### Non-Functional / Design Expectations
- Machine states should be explicit.
- Inventory and payment logic should be separated.
- Product catalog should be easy to extend.

### Follow-up Constraints
- Add card or UPI payments.
- Add admin restocking operations.
- Add transaction cancellation and refund flow.

---

## 10. Rate Limiter

### Problem
Design a rate limiter library for API requests.

### Functional Specs
- Decide whether a request is allowed for a client key.
- Support configurable limits and time windows.
- Expose a simple API for checking allowance.
- Support at least fixed window and sliding window approaches.

### Non-Functional / Design Expectations
- Rate limiting algorithms should be interchangeable.
- The library should remain easy to embed in different applications.
- Time source should be abstracted for testability.

### Follow-up Constraints
- Add distributed storage support.
- Add per-user and per-endpoint limits.
- Add metrics and observability hooks.

---

## 11. Notification System

### Problem
Design a notification system that can send messages through multiple channels.

### Functional Specs
- Support channels such as email, SMS, and push notifications.
- Allow clients to trigger notifications with message content.
- Support templates for message formatting.
- Support user preferences for enabled channels.
- Track delivery status.

### Non-Functional / Design Expectations
- Channel implementations should be independent.
- Template handling should be reusable.
- The design should support adding new channels without changing core flow.

### Follow-up Constraints
- Add retry policies.
- Add scheduled notifications.
- Add bulk notifications.

---

## 12. Chess Game

### Problem
Design the backend model for a chess game.

### Functional Specs
- Represent board, pieces, and players.
- Validate legal moves for each piece.
- Support turn-based play.
- Detect check and checkmate at a high level.
- Track game state and move history.

### Non-Functional / Design Expectations
- Piece movement logic should be extensible and isolated.
- Board state should be easy to inspect and test.
- The design should not overcomplicate advanced rules initially.

### Follow-up Constraints
- Add castling, en passant, and promotion.
- Add undo functionality.
- Add support for timers.

---

## Suggested Practice Format

For each question, write down:

1. Requirements and assumptions
2. Core classes and enums
3. Key interfaces and responsibilities
4. Important workflows
5. Design patterns used
6. Edge cases
7. Future extensions

## Suggested Order

If you are starting out, this order keeps complexity manageable:

1. Snake and Ladder
2. Vending Machine
3. Parking Lot System
4. Library Management System
5. Splitwise System
6. Cache System
7. Elevator System
8. Movie Ticket Booking System
9. ATM System
10. Notification System
11. Rate Limiter
12. Chess Game
