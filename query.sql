-- Inserting data into the Category table
INSERT INTO Category (name) VALUES
                                ('Electronics'),
                                ('Clothing'),
                                ('Home Appliances'),
                                ('Books'),
                                ('Sports Gear'),
                                ('Furniture'),
                                ('Beauty & Personal Care'),
                                ('Toys & Games'),
                                ('Automotive'),
                                ('Jewelry');

-- Inserting data into the Item table
INSERT INTO Item (name, description, photo, price, seller, category_id) VALUES
-- Electronics
('Smart TV', '55-inch 4K Ultra HD Smart TV with HDR and built-in streaming apps.', 'smart_tv.jpg', 899.99, 'Samsung Inc.', 1),
('iPhone 13', 'Newest iPhone model with improved camera and performance.', 'iphone_13.jpg', 999.99, 'Apple Inc.', 1),
('Sony PlayStation 5', 'Next-generation gaming console with 4K graphics and high-speed SSD.', 'playstation_5.jpg', 499.99, 'Sony Corporation', 1),
('DJI Mavic Air 2', 'Compact drone with 4K camera, obstacle avoidance, and intelligent tracking.', 'dji_mavic_air_2.jpg', 799.99, 'DJI Inc.', 1),
('Bose QuietComfort 45', 'Wireless noise-canceling headphones with up to 24 hours of battery life.', 'bose_quietcomfort_45.jpg', 329.99, 'Bose Corporation', 1),

-- Clothing
('Leather Jacket', 'Genuine leather jacket with zippered pockets and quilted lining.', 'leather_jacket.jpg', 249.99, 'Fashion Co.', 2),
('Denim Jeans', 'Classic blue jeans made from premium denim fabric.', 'denim_jeans.jpg', 59.99, 'Denim Fashion Ltd.', 2),
('Hooded Sweatshirt', 'Comfortable hooded sweatshirt with fleece lining and front pocket.', 'hooded_sweatshirt.jpg', 39.99, 'Casual Wear Inc.', 2),
('Running Shoes', 'Lightweight running shoes with breathable mesh upper and cushioned sole.', 'running_shoes.jpg', 89.99, 'Athletic Gear Co.', 2),
('Formal Dress', 'Elegant formal dress with lace detailing and A-line silhouette.', 'formal_dress.jpg', 199.99, 'Evening Couture', 2),

-- Home Appliances
('Refrigerator', 'Energy-efficient refrigerator with adjustable shelves and ice maker.', 'refrigerator.jpg', 1499.99, 'Appliances Unlimited', 3),
('Robot Vacuum Cleaner', 'Smart robot vacuum cleaner with mapping technology and self-emptying bin.', 'robot_vacuum_cleaner.jpg', 399.99, 'Home Tech Solutions', 3),
('Instant Pot Duo', 'Multi-functional pressure cooker for fast and easy cooking.', 'instant_pot_duo.jpg', 99.99, 'Instant Brands Inc.', 3),
('Air Fryer', 'Compact air fryer for frying, baking, grilling, and roasting with little to no oil.', 'air_fryer.jpg', 79.99, 'Kitchen Essentials Ltd.', 3),
('Espresso Machine', 'High-quality espresso machine with built-in grinder and frother.', 'espresso_machine.jpg', 299.99, 'Coffee Co.', 3),

-- Books
('The Great Gatsby', 'Classic novel by F. Scott Fitzgerald depicting the Jazz Age.', 'great_gatsby.jpg', 9.99, 'Penguin Random House', 4),
('To Kill a Mockingbird', 'Pulitzer Prize-winning novel by Harper Lee addressing racial injustice.', 'to_kill_a_mockingbird.jpg', 12.99, 'HarperCollins Publishers', 4),
('1984', 'Dystopian novel by George Orwell depicting totalitarian society.', '1984.jpg', 11.99, 'Orwell Publishing', 4),
('Harry Potter and the Sorcerer''s Stone', 'First book in the Harry Potter series by J.K. Rowling.', 'harry_potter_sorcerers_stone.jpg', 12.99, 'Scholastic Inc.', 4),
('The Catcher in the Rye', 'Coming-of-age novel by J.D. Salinger.', 'catcher_in_the_rye.jpg', 10.99, 'Little, Brown and Company', 4),

-- Sports Gear
('Basketball', 'Official NBA basketball made of durable composite leather.', 'basketball.jpg', 29.99, 'Sporting Goods Inc.', 5),
('Yoga Mat', 'Extra-thick yoga mat with non-slip surface for yoga and exercise routines.', 'yoga_mat.jpg', 19.99, 'Fitness Essentials', 5),
('Dumbbell Set', 'Adjustable dumbbell set with various weight plates for strength training.', 'dumbbell_set.jpg', 129.99, 'Gym Equipment Co.', 5),
('Tennis Racket', 'Graphite tennis racket with oversized head for power and control.', 'tennis_racket.jpg', 89.99, 'Sports Gear Outlet', 5),
('Soccer Ball', 'Official FIFA soccer ball for professional and recreational play.', 'soccer_ball.jpg', 39.99, 'Soccer World', 5);

-- Inserting data into the Item table for the remaining categories
INSERT INTO Item (name, description, photo, price, seller, category_id) VALUES
                                                                            ('Smartwatch', 'Fitness tracker with heart rate monitor and GPS tracking.', 'smartwatch.jpg', 199.99, 'Tech Innovations Ltd.', 1),
                                                                            ('Denim Jeans', 'Classic blue denim jeans with a relaxed fit and distressed detailing.', 'denim_jeans.jpg', 59.99, 'Fashion Trends Inc.', 2),
                                                                            ('Coffee Maker', 'Programmable coffee maker with a stainless steel carafe.', 'coffee_maker.jpg', 79.99, 'Kitchen Gadgets Co.', 3),
                                                                            ('The Hobbit', 'Fantasy novel by J.R.R. Tolkien featuring Bilbo Baggins on an epic adventure.', 'the_hobbit.jpg', 14.99, 'HarperCollins Publishers', 4),
                                                                            ('Yoga Mat', 'Non-slip yoga mat with cushioned support for comfortable workouts.', 'yoga_mat.jpg', 24.99, 'Fitness Essentials Store', 5),
                                                                            ('Sofa Set', 'Modern sectional sofa set with adjustable headrests and reclining features.', 'sofa_set.jpg', 1499.99, 'Home Furnishings Inc.', 6),
                                                                            ('Face Cream', 'Moisturizing face cream enriched with vitamins and antioxidants.', 'face_cream.jpg', 29.99, 'Skin Care Solutions', 7),
                                                                            ('Board Games Bundle', 'Collection of classic board games including Monopoly, Scrabble, and Clue.', 'board_games_bundle.jpg', 49.99, 'Game Night Emporium', 8),
                                                                            ('Motor Oil', 'High-performance synthetic motor oil for optimal engine protection.', 'motor_oil.jpg', 39.99, 'Auto Supply Co.', 9),
                                                                            ('Diamond Stud Earrings', 'Timeless diamond stud earrings in a classic prong setting.', 'diamond_stud_earrings.jpg', 1999.99, 'Luxury Jewelry Boutique', 10);

-- Inserting data into the Item table for remaining categories
INSERT INTO Item (name, description, photo, price, seller, category_id) VALUES
                                                                            ('Running Shoes', 'Lightweight running shoes with breathable mesh upper.', 'running_shoes.jpg', 79.99, 'Athletic Gear Co.', 5),
                                                                            ('Tennis Racket', 'Professional-grade tennis racket with carbon fiber frame.', 'tennis_racket.jpg', 149.99, 'Sports Pro Shop', 5),
                                                                            ('Yoga Mat', 'Eco-friendly yoga mat with non-slip surface and carrying strap.', 'yoga_mat.jpg', 29.99, 'Yoga Supplies Store', 5),
                                                                            ('Hiking Backpack', 'Durable hiking backpack with padded straps and multiple compartments.', 'hiking_backpack.jpg', 89.99, 'Outdoor Gear Co.', 5),
                                                                            ('Soccer Ball', 'Official FIFA soccer ball with hand-stitched construction.', 'soccer_ball.jpg', 39.99, 'Soccer World', 5),

                                                                            ('Coffee Maker', 'Programmable coffee maker with stainless steel carafe and brew strength options.', 'coffee_maker.jpg', 69.99, 'Kitchen Appliances Inc.', 6),
                                                                            ('Sofa Set', 'Contemporary sofa set with plush cushions and hardwood frame.', 'sofa_set.jpg', 899.99, 'Furniture Emporium', 6),
                                                                            ('Bedroom Dresser', 'Wooden bedroom dresser with six drawers and antique brass handles.', 'bedroom_dresser.jpg', 299.99, 'Home Decor Co.', 6),
                                                                            ('TV Stand', 'Modern TV stand with open shelves and cable management system.', 'tv_stand.jpg', 149.99, 'Furniture Outlet', 6),
                                                                            ('Dining Chair Set', 'Set of four upholstered dining chairs with tufted backs.', 'dining_chair_set.jpg', 199.99, 'Home Goods Store', 6),

                                                                            ('Facial Cleanser', 'Gentle facial cleanser with natural ingredients and vitamin E.', 'facial_cleanser.jpg', 14.99, 'Skin Care Co.', 7),
                                                                            ('Anti-Aging Cream', 'Moisturizing anti-aging cream enriched with collagen and peptides.', 'anti_aging_cream.jpg', 29.99, 'Beauty Boutique', 7),
                                                                            ('Hair Dryer', 'Professional-grade hair dryer with ionic technology and multiple heat settings.', 'hair_dryer.jpg', 49.99, 'Salon Supplies Inc.', 7),
                                                                            ('Lipstick Set', 'Matte lipstick set with long-lasting formula and vibrant colors.', 'lipstick_set.jpg', 19.99, 'Makeup Emporium', 7),
                                                                            ('Body Lotion', 'Hydrating body lotion infused with shea butter and jojoba oil.', 'body_lotion.jpg', 9.99, 'Luxury Spa', 7),

                                                                            ('Board Game', 'Classic board game for family fun and strategic gameplay.', 'board_game.jpg', 24.99, 'Toy Store', 8),
                                                                            ('Remote Control Car', 'High-speed remote control car with rechargeable battery and 2.4GHz remote.', 'remote_control_car.jpg', 39.99, 'Hobby Shop', 8),
                                                                            ('Puzzle Set', 'Collection of jigsaw puzzles with varying difficulty levels.', 'puzzle_set.jpg', 19.99, 'Puzzle Palace', 8),
                                                                            ('Action Figure Set', 'Collectible action figures featuring characters from popular movies.', 'action_figure_set.jpg', 49.99, 'Collectibles Store', 8),
                                                                            ('Play Kitchen Set', 'Interactive play kitchen set with pretend appliances and accessories.', 'play_kitchen_set.jpg', 79.99, 'Kids Toys Inc.', 8),

                                                                            ('Car Wax', 'High-quality car wax for a glossy finish and long-lasting protection.', 'car_wax.jpg', 19.99, 'Auto Detailing Supplies', 9),
                                                                            ('Jump Starter', 'Portable jump starter with built-in flashlight and USB charging ports.', 'jump_starter.jpg', 79.99, 'Automotive Tools Co.', 9),
                                                                            ('Car Seat Covers', 'Universal-fit car seat covers with breathable mesh fabric.', 'car_seat_covers.jpg', 29.99, 'Car Accessories Shop', 9),
                                                                            ('Windshield Wipers', 'All-weather windshield wipers with durable rubber blades.', 'windshield_wipers.jpg', 14.99, 'Auto Parts Center', 9),
                                                                            ('Car Wash Kit', 'Complete car wash kit with soap, sponge, and microfiber towels.', 'car_wash_kit.jpg', 29.99, 'Car Care Supplies', 9),

                                                                            ('Gold Stud Earrings', 'Classic gold stud earrings with secure screw backs.', 'gold_stud_earrings.jpg', 199.99, 'Jewelry Boutique', 10),
                                                                            ('Diamond Engagement Ring', 'Exquisite diamond engagement ring with platinum setting.', 'diamond_engagement_ring.jpg', 4999.99, 'Fine Jewelry Co.', 10),
                                                                            ('Silver Bracelet', 'Sterling silver bracelet with intricate filigree design.', 'silver_bracelet.jpg', 99.99, 'Silver Jewelry Store', 10),
                                                                            ('Pearl Necklace', 'Timeless pearl necklace featuring freshwater pearls and sterling silver clasp.', 'pearl_necklace.jpg', 299.99, 'Pearl Jewelry Emporium', 10),
                                                                            ('Gemstone Ring', 'Handcrafted gemstone ring with natural sapphire and diamond accents.', 'gemstone_ring.jpg', 799.99, 'Gemstone Jewelry Co.', 10);

-- Inserting admin account
INSERT INTO [user](name, username, password, admin)
values ('admin1', 'admin1', 'admin1', 1)