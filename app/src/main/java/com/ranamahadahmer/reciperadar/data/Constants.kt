package com.ranamahadahmer.reciperadar.data

val cuisines = listOf(
    "African",
            "Asian",
            "American",
            "British",
            "Cajun",
            "Caribbean",
            "Chinese",
            "Eastern European",
            "European",
            "French",
            "German",
            "Greek",
            "Indian",
            "Irish",
            "Italian",
            "Japanese",
            "Jewish",
            "Korean",
            "Latin American",
            "Mediterranean",
            "Mexican",
            "Middle Eastern",
            "Nordic",
            "Southern",
            "Spanish",
            "Thai",
            "Vietnamese"
)

val diets = mapOf(
        "Gluten Free" to
                "Eliminating gluten means avoiding wheat, barley, rye, and other gluten-containing grains and foods made from them (or that may have been cross contaminated).",

        "Ketogenic" to
        "The keto diet is based more on the ratio of fat, protein, and carbs in the diet rather than specific ingredients. Generally speaking, high fat, protein-rich foods are acceptable and high carbohydrate foods are not. The formula we use is 55-80% fat content, 15-35% protein content, and under 10% of carbohydrates.",

        "Vegetarian" to
        "No ingredients may contain meat or meat by-products, such as bones or gelatin.",

        "Lacto-Vegetarian" to
        "All ingredients must be vegetarian and none of the ingredients can be or contain egg.",

        "Ovo-Vegetarian" to
        "All ingredients must be vegetarian and none of the ingredients can be or contain dairy.",

        "Vegan" to
        "No ingredients may contain meat or meat by-products, such as bones or gelatin, nor may they contain eggs, dairy, or honey.",

        "Pescetarian" to
        "Everything is allowed except meat and meat by-products - some pescetarians eat eggs and dairy, some do not.",

        "Paleo" to
        "Allowed ingredients include meat (especially grass fed), fish, eggs, vegetables, some oils (e.g. coconut and olive oil), and in smaller quantities, fruit, nuts, and sweet potatoes. We also allow honey and maple syrup (popular in Paleo desserts, but strict Paleo followers may disagree). Ingredients not allowed include legumes (e.g. beans and lentils), grains, dairy, refined sugar, and processed foods.",

        "Primal" to
        "Very similar to Paleo, except dairy is allowed - think raw and full fat milk, butter, ghee, etc.",

        "Low FODMAP" to
         "FODMAP stands for 'fermentable oligo-, di-, mono-saccharides and polyols.' Our ontology knows which foods are considered high in these types of carbohydrates (e.g. legumes, wheat, and dairy products)",

        "Whole30" to
        "Allowed ingredients include meat, fish/seafood, eggs, vegetables, fresh fruit, coconut oil, olive oil, small amounts of dried fruit and nuts/seeds. Ingredients not allowed include added sweeteners (natural and artificial, except small amounts of fruit juice), dairy (except clarified butter or ghee), alcohol, grains, legumes (except green beans, sugar snap peas, and snow peas), and food additives, such as carrageenan, MSG, and sulfites."
)

val mealTypes = listOf(
        "Main course",
        "Side dish",
        "Dessert",
        "Appetizer",
        "Salad",
        "Bread",
        "Breakfast",
        "Soup",
        "Beverage",
        "Sauce",
        "Marinade",
        "Fingerfood",
        "Snack",
        "Drink",
)

val sortBy= listOf(
        "",
        "Meta-score",
        "Popularity",
        "Healthiness",
        "Price",
        "Time",
        "Random",
        "Max-Used-Ingredients",
        "Min-Missing-Ingredients",
        "Alcohol",
        "Caffeine",
        "Copper",
        "Energy",
        "Calories",
        "Calcium",
        "Carbohydrates",
        "Carbs",
        "Choline",
        "Cholesterol",
        "Total-Fat",
        "Fluoride",
        "Trans-Fat",
        "Saturated-Fat",
        "Mono-Unsaturated-Fat",
        "Poly-Unsaturated-Fat",
        "Fiber",
        "Folate",
        "Folic-Acid",
        "Iodine",
        "Iron",
        "Magnesium",
        "Manganese",
        "Vitamin-B3",
        "Niacin",
        "Vitamin-B5",
        "Pantothenic-Acid",
        "Phosphorus",
        "Potassium",
        "Protein",
        "Vitamin-B2",
        "Riboflavin",
        "Selenium",
        "Sodium",
        "Vitamin-b1",
        "Thiamin",
        "Vitamin-A",
        "Vitamin-B6",
        "Vitamin-B12",
        "Vitamin-C",
        "Vitamin-D",
        "Vitamin-E",
        "Vitamin-K",
        "Sugar",
        "Zinc",
)