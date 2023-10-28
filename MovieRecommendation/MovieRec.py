from flask import Flask, render_template, request

app = Flask(__name__)

total_seats = 10
price = 5
movie_price = 0

class Movie:
    def __init__(self, movie_list, seat_status="seat taken"):
        self.movie_list = movie_list
        self.seat_status = seat_status

movies = []

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/movies')
def view_movies():
    return render_template('movies.html', movies=movies)

@app.route('/seats')
def view_seats():
    return render_template('seats.html', total_seats=total_seats)

@app.route('/booking', methods=['GET', 'POST'])
def booking():
    if request.method == 'POST':
        movie_name = request.form['movie_name']
        seat = int(request.form['seat'])
        
        for movie in movies:
            if movie.movie_list == movie_name:
                movie.seat_status = "seat {} taken".format(seat)
                global total_seats
                total_seats -= 1
                global movie_price
                movie_price += price
                break

    return render_template('booking.html', movies=movies)

@app.route('/total_cost')
def total_cost():
    return render_template('total_cost.html', movie_price=movie_price)

if __name__ == '__main__':
    movies = [Movie("Movie A"), Movie("Movie B"), Movie("Movie C")]

    app.run()
