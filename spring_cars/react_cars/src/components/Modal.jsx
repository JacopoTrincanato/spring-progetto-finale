export default function Modal() {

    return (
        <>
            <div className="modal fade" id={`modal-{}`} data-bs-backdrop="static" data-bs-keyboard="false"
                tabIndex="-1" aria-labelledby={`modalLabel-{}`} aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h1 className="modal-title fs-5" id={`modalLabel-{}`}>
                                Delete car
                            </h1>
                            <button type="button" className="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                        </div>
                        <div className="modal-body">
                            Are you sure you want to delete the car:
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
        </>
    )
}