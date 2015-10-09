# A&F app

## Installation

1. Clone the repo
2. Build the Gradle
3. Run the project

## Usage

1. The app includes sliding panel, which provides the users with the information about promotions. If the app is initially started in offline mode, there is a default image on the panel.
2.Floating action button directs the users to a certain webpage.
3. The data is cached for offline use.

#Comments
The endpoint provided in the instructions (http://www.abercrombie.com/anf/nativeapp/Feeds/promotions.json) should be improved. In the JSON array "promotions" there is a field "button", which is an object n first case and an array in the second case. I was not sure whether it was done intentionally or it is a bug. That is the reason why I was not using API data under the category "button", but provided a constants in the class.

I wish I could spend more time to devote to design aspects. I hope to demonstrate my design skill further down the road.


## License

The MIT License (MIT)

Copyright (c) 2015 A&F

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
