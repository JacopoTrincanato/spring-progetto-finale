import { Link } from "react-router-dom";
export default function CarCard({ car }) {

    return (
        <>
            <div className="car-card">
                <img src={car.urlImage} className="card-img-top" />
                <div className="card-body p-3">
                    <h5 className="card-title">{car.model}</h5>
                    <p className="card-text">{car.description}</p>
                    <Link className="btn btn-car" to={`/${car.id}`}>Details</Link>
                </div>
                <button type="button" className="btn delete-btn" data-bs-toggle="modal"
                    data-bs-target={`#modal-${car.id}`}>
                    &#10005;
                </button>
            </div>
        </>
    )
}