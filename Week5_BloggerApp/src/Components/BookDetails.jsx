import React from "react";

function BookDetails(props) {

    return (

        <div>

            <h1>Book Details</h1>

            <ul>

                {
                    props.books.map(book => (

                        <div key={book.id}>
                            <h3>{book.bname}</h3>
                            <h4>{book.price}</h4>
                        </div>

                    ))
                }

            </ul>

        </div>

    );

}

export default BookDetails;