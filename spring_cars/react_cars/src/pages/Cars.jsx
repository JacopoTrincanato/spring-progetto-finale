import { Link } from "react-router-dom";

export default function Cars() {


    return (
        <>

            <div className="container text-center mt-3 p-3">
                <h1>Our Cars</h1>
            </div>

            <div className="container mt-4">
                <div className="row g-4 d-flex justify-content-between">
                    <div className="col-sm-6 col-md-4">
                        <div className="car-card">
                            <img src={urlImage} className="card-img-top" />
                            <div className="card-body p-3">
                                <h5 className="card-title">{model}</h5>
                                <p className="card-text">{description}</p>
                                <Link className="btn btn-car" to={`/${id}`}>Details</Link>
                            </div>
                            <button type="button" className="btn delete-btn" data-bs-toggle="modal"
                                data-bs-target="'#modal-' + *{id}">
                                &#10005;
                            </button>
                        </div>
                    </div>

                    <div className="btn-modals">

                        {/*Modale*/}
                        <div className="modal fade" id={`modal-${id}`} data-bs-backdrop="static" data-bs-keyboard="false"
                            tabindex="-1" aria-labelledby={`modalLabel-${id}`} aria-hidden="true">
                            <div className="modal-dialog">
                                <div className="modal-content">
                                    <div className="modal-header">
                                        <h1 className="modal-title fs-5" id={`modalLabel-${id}`}>
                                            Delete car {model}
                                        </h1>
                                        <button type="button" className="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                    </div>
                                    <div className="modal-body">
                                        Are you sure you want to delete the car: {model}
                                    </div>
                                    <div className="modal-footer">
                                        <button type="button" className="btn btn-secondary"
                                            data-bs-dismiss="modal">Close</button>
                                        <form action="@{/cars/delete/{id}(id=*{id})}">
                                            <button type="submit" className="btn btn-danger">Delete</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </>
    )
}